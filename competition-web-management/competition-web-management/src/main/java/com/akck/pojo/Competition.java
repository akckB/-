package com.akck.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Competition {
    private int id;// 比赛id
    private String name;// 比赛名称
    private String img; //图像url
    private String introduction;// 比赛的简介
    private String sponsor;// 比赛的主办方
    private String type;// 比赛类型 团体赛 or 个人赛
    private int entryQuota;// 参赛名额
    private int registeredPeople;// 已经报名的人数
    private LocalDate startTime;// 比赛报名的开始时间
    private String status;// 比赛的状态 正在报名/已截止/未开始
    private LocalDate endTime;// 比赛报名的结束时间
    private LocalDateTime createTime;// 创建比赛的时间
    private LocalDateTime updateTime;// 比赛修改的时间
}
