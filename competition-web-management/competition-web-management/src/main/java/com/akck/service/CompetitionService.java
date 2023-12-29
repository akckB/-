package com.akck.service;

import com.akck.pojo.Competition;

import java.util.List;

public interface CompetitionService {
    /**
     * 查询全部比赛数据
     *
     * @return
     */
    List<Competition> list();

    /**
     * 删除比赛
     */
    void delete(Integer competitionId);

    /**
     * 新增比赛
     *
     * @param competition
     */
    void save(Competition competition);

    /**
     * 根据id来查询比赛
     *
     * @param id
     * @return
     */
    Competition getById(Integer id);

    /**
     * 跟新比赛的
     *
     * @param competition
     */
    void update(Competition competition);

    /**
     * 实现根据比赛数据将比赛按照开始时间进行升序排序
     *
     * @return
     */
    List<Competition> getCompetitionsSortedByStartTime();

    /**
     * 实现根据比赛数据将比赛按照开始时间进行降序排序
     *
     * @return
     */
    List<Competition> getCompetitionsSortedByStartTimeDesc();

    /**
     * 实现比赛报名的接口
     *
     * @param userId
     * @param competitionId
     * @return
     */
    String signUpFor(Integer userId, Integer competitionId);

    /**
     * 实现取消报名的接口
     *
     * @param userId
     * @param competitionId
     */
    String signDownFor(Integer userId, Integer competitionId);

    /**
     * 实现查询可以报名比赛的个数的接口
     *
     * @return
     */
    Integer getNumber();

    /**
     * 查询当前的登录用户报名的比赛列表
     *
     * @param userId
     * @return
     */
    List<Competition> getUserCompetition(Integer userId);

    /**
     * 根据比赛名称查询比赛的全部信息
     *
     * @param name
     * @return
     */
    Competition getByName(String name);

    /**
     * 根据主办方名称查询比赛
     *
     * @param sponsor
     * @return
     */
    List<Competition> getBySponser(String sponsor);
}
