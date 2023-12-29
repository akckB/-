package com.akck.service.impl;

import com.akck.mapper.CompetitionMapper;
import com.akck.pojo.Competition;
import com.akck.service.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static java.time.LocalDate.*;

@Service
public class CompetitionServiceImpl implements CompetitionService {

    @Autowired
    private CompetitionMapper competitionMapper;

    @Override
    public List<Competition> list() {
        return competitionMapper.list();
    }

    @Override
    public void delete(Integer competitionId) {
        competitionMapper.deleteById(competitionId);
        // 比赛删除完成之后 要将关联表中比赛有关的数据删除
        competitionMapper.deleteUserCompetition(competitionId);
    }

    @Override
    public void save(Competition competition) {
        competition.setCreateTime(LocalDateTime.now());
        competition.setUpdateTime(LocalDateTime.now());
        competitionMapper.insert(competition);
    }

    @Override
    public Competition getById(Integer id) {
        return competitionMapper.getById(id);
    }

    @Override
    public void update(Competition competition) {
        competition.setUpdateTime(LocalDateTime.now());
        competitionMapper.update(competition);
    }

    public List<Competition> getCompetitionsSortedByStartTime() {
        return competitionMapper.getCompetitionsSortedByStartTime();
    }

    @Override
    public List<Competition> getCompetitionsSortedByStartTimeDesc() {
        return competitionMapper.findByOrderByStartTimeDesc();
    }

    @Override
    public String signUpFor(Integer userId, Integer competitionId) {
        Competition competition = competitionMapper.getById(competitionId);
        LocalDate now = LocalDate.now();
        // 报名时间判定
        if (now.isAfter(competition.getStartTime()) && now.isBefore(competition.getEndTime())) {
        } else {
            return "不在报名时间内";
        }
        try {
            Integer index = competitionMapper.signSelect(userId, competitionId);
            if (index == 1) {
                return "你已经报名了本次比赛比赛";
            }
        } catch (Exception e) {
        }
        if (competition.getEntryQuota() >= competition.getRegisteredPeople()) {
            // 满足条件 报名比赛 让比赛的报名人数加一
            int registeredPeople = competition.getRegisteredPeople();
            competition.setRegisteredPeople(registeredPeople + 1);
            // 调用数据库调整数据
            competitionMapper.update(competition);
            try {
                competitionMapper.signUpFor(userId, competitionId);
            } catch (Exception e) {
                return "你已经报名了本次比赛比赛";
            }
            return "报名成功";
        } else {
            return "人数已满";
        }
    }

    @Override
    public String signDownFor(Integer userId, Integer competitionId) {
        // 首先通过数据库的查询语句获得关联表中这个用户是否参加了这个比赛
        Integer index = competitionMapper.signSelect(userId, competitionId);
        if (index !=null) {
            competitionMapper.signDownFor(userId, competitionId);
            Competition competition = competitionMapper.getById(competitionId);
            int registeredPeople = competition.getRegisteredPeople();
            // 取消报名，所以比赛的参加人数减一
            competition.setRegisteredPeople(registeredPeople - 1);
            competitionMapper.update(competition);
            return "1";
        }
        return "0";
    }

    @Override
    public Integer getNumber() {
        return competitionMapper.getNumber();
    }

    @Override
    public List<Competition> getUserCompetition(Integer userId) {
        List<Competition> list = competitionMapper.getUserCompetition(userId);
        return list;
    }

    @Override
    public Competition getByName(String name) {
        Competition competition = competitionMapper.getByName(name);
        return competition;
    }

    @Override
    public List<Competition> getBySponser(String sponsor) {
        List<Competition> list = competitionMapper.getBySponser(sponsor);
        return list;
    }

}
