package com.akck.controller;


import com.akck.anno.Log;
import com.akck.pojo.Competition;
import com.akck.pojo.Result;
import com.akck.pojo.UserCompetition;
import com.akck.service.CompetitionService;
import com.akck.utils.JwtUtils;
import com.akck.utils.ThreadLocalUtil;
import io.jsonwebtoken.Claims;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/competitions")
public class CompetitionConyroller {

    @Autowired
    private CompetitionService competitionService;


    /**
     * 查询比赛数据
     *
     * @return
     */
    @GetMapping
    public Result list() {
        log.info("查询全部比赛信息");
        List<Competition> competitionList = competitionService.list();
        return Result.success(competitionList);
    }

    /**
     * 删除比赛数据
     *
     * @param id
     */
    @Log
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        String token = ThreadLocalUtil.get();
        Claims claims = JwtUtils.parseJWT(token);
        String role = (String) claims.get("role");
        if (role.equals("1")) {
            return Result.success("权限不足");
        }
        // @PathVariable 绑定数据
        log.info("删除比赛信息:{}", id);
        competitionService.delete(id);
        // 删除完比赛将关联表中的数据删除
        return Result.success("删除成功");
    }

    /**
     * 新增比赛的操作
     *
     * @param competition
     * @return
     */
    @Log
    @PostMapping
    public Result save(@RequestBody Competition competition) {
        String token = ThreadLocalUtil.get();
        Claims claims = JwtUtils.parseJWT(token);
        String role = (String) claims.get("role");
        if (role.equals("1")) {
            return Result.success("权限不足");
        }
        log.info("新增比赛，competition:{}", competition);
        competitionService.save(competition);
        return Result.success("新增成功");
    }

    /**
     * 根据id查询比赛
     *
     * @return
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        log.info("根据id查询比赛数据，id{}", id);
        Competition competition = competitionService.getById(id);
        return Result.success(competition);
    }

    /**
     * 根据比赛名称查询比赛
     *
     * @return
     */
    @GetMapping("/findByName")
    public Result getByName(@RequestParam String name) {
        log.info("根据name查询比赛数据，name{}", name);
        Competition competition = competitionService.getByName(name);
        return Result.success(competition);
    }

    /**
     * 根据主办方名称查询比赛
     *
     * @return
     */
    @GetMapping("/findBySponsor")
    public Result getBy(@RequestParam String sponsor) {
        log.info("根据name查询比赛数据，name{}", sponsor);
        List<Competition> list = competitionService.getBySponser(sponsor);
        return Result.success(list);
    }

    /**
     * 跟新比赛操作
     *
     * @return
     */
    @Log
    @PutMapping
    public Result Update(@RequestBody Competition competition) {
        String token = ThreadLocalUtil.get();
        Claims claims = JwtUtils.parseJWT(token);
        String role = (String) claims.get("role");
        if (role.equals("1")) {
            return Result.success("权限不足");
        }
        log.info("跟新比赛的信息：,{}", competition);
        competitionService.update(competition);
        return Result.success("更新成功");
    }

    /**
     * 实现根据比赛数据将比赛按照开始时间进行升序排序
     *
     * @return
     */
    @GetMapping("/asc")
    public List<Competition> getCompetitionsSortedByStartTime() {
        return competitionService.getCompetitionsSortedByStartTime();
    }

    /**
     * 实现根据比赛数据将比赛按照开始时间进行降序排序
     *
     * @return
     */
    @GetMapping("/desc")
    public List<Competition> getCompetitionsSortedByStartTimeDesc() {
        return competitionService.getCompetitionsSortedByStartTimeDesc();
    }

    /**
     * 实现比赛报名的接口
     *
     * @return
     */
    @PostMapping("/signUp/{competitionId}")
    public Result signUpForCompetition(@PathVariable("competitionId") Integer competitionId) {
        // 从ThreadLocal中获取token并解析出用户ID
        String token = ThreadLocalUtil.get();
        Claims claims = JwtUtils.parseJWT(token);
        Integer userId = (Integer) claims.get("id");
        String information = competitionService.signUpFor(userId, competitionId);
        return Result.success(information);
    }


    /**
     * 实现放弃比赛的接口
     *
     * @param competitionId
     * @return
     */
    @DeleteMapping("/signDown/{competitionId}")
    public Result signDownForCompetition(@PathVariable("competitionId") Integer competitionId) {
        String token = ThreadLocalUtil.get();
        Claims claims = JwtUtils.parseJWT(token);
        // 使用claims方法获取对象的信息
        Integer userId = (Integer) claims.get("id");
        String index = competitionService.signDownFor(userId, competitionId);
        if (index.equals("1")) {
            return Result.success();
        }
        return Result.error("未参加比赛");
    }

    /**
     * 展示可报名比赛的个数
     */
    @GetMapping("/numbers")
    public Result competitionNumber() {
        Integer number = competitionService.getNumber();
        return Result.success(number);
    }

    /**
     * 展示用已经报名的比赛
     */
    @GetMapping("/show")
    public Result showCompetition() {
        String token = ThreadLocalUtil.get();
        Claims claims = JwtUtils.parseJWT(token);
        // 使用claims方法获取对象的信息
        Integer userId = (Integer) claims.get("id");
        List<Competition> competitionList = competitionService.getUserCompetition(userId);
        return Result.success(competitionList);
    }
}
