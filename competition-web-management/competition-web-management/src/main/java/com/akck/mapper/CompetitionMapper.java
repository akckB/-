package com.akck.mapper;


import com.akck.pojo.Competition;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CompetitionMapper {


    /**
     * 用于在删除比赛之后，将关联表中的相关数据都删除掉
     * @param competitionId
     */
    @Delete("delete from user_competition where competition_id = #{competitionId}")
    void deleteUserCompetition(Integer competitionId);

    /**
     * 根据id查询比赛
     *
     * @param id
     * @return
     */
    @Select("select * from competition where id = #{id}")
    Competition getById(Integer id);

    /**
     * 用来查询全部的比赛数据
     *
     * @return
     */
    @Select("select * from competition")
    List<Competition> list();

    /**
     * 根据id删除比赛
     *
     * @param id
     */
    @Delete("delete from competition where id = #{id}")
    void deleteById(Integer id);

    /**
     * 新增比赛
     *
     * @param competition
     */
    @Insert("insert into competition(id,name,introduction, sponsor, type, entry_quota, registered_people, start_time,status,end_time,create_time,update_time)" +
            "values (#{id},#{name},#{introduction},#{sponsor},#{type},#{entryQuota},#{registeredPeople},#{startTime},#{status},#{endTime},#{createTime},#{updateTime})")
    void insert(Competition competition);

    /**
     * 跟新比赛的操作
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
     * 现根据比赛数据将比赛按照开始时间进行降序排序
     *
     * @return
     */
    List<Competition> findByOrderByStartTimeDesc();

    /**
     * 实现参加比赛的接口
     */
    @Insert("insert into user_competition (user_id, competition_id) values (#{userId}, #{competitionId})")
    void signUpFor(Integer userId, Integer competitionId);

    /**
     * 实现取消比赛的接口
     *
     * @param userId
     * @param competitionId
     */
    @Delete("delete from user_competition where user_id = #{userId} and competition_id = #{competitionId}")
    Integer signDownFor(Integer userId, Integer competitionId);

    /**
     * 查询用户对于选择比赛的报名情况
     *
     * @param userId
     * @param competitionId
     */
    @Select("select * from user_competition where user_id = #{userId} and competition_id = #{competitionId}")
    Integer signSelect(Integer userId, Integer competitionId);

    /**
     * 展示可以参加比赛的个数
     */
    @Select("select count(*) from competition where status = '进行中'")
    Integer getNumber();

    List<Competition> getUserCompetition(Integer userId);

    /**
     * 根据比赛的名称对比赛进行查询
     * @return
     */
    @Select("select * from competition where name = #{name}")
    Competition getByName(String name);

    /**
     * 根据主办方名称对比赛进行查询
     *
     * @param sponsor
     * @return
     */
    @Select("select * from competition where sponsor=#{sponsor}")
    List<Competition> getBySponser(String sponsor);
}
