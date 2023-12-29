package com.akck.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 关联表 使用用户id和比赛id进行关联 从而让用户也可查询到自己的报名比赛
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCompetition {

    private int userId;// 用户id
    private int competitionId;// 比赛id
}
