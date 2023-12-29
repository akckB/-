package com.akck.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @NotNull
    private int id;// 用户的id 主键自增 不用管
    private String username;// 用户的用户名
    // 让springmvc把当前对象转换成json字符串的时候，忽略password,这样就可以不把passsword展示
    private String password;// 用户的密码
    @NotEmpty// 限定必须要传
    @Pattern(regexp = "^\\S{1,10}$")
    private String name;// 用户的真实姓名
    private String gender;// 用户的性别
    private String phonenumber;//用户的手机号码
    @Email// 完成邮箱校验
    @NotEmpty
    private String email;//用户的邮箱
    private String role;//用户的权限
    private String userImg;//用户的头像
    private LocalDateTime createTime;// 创建用户的时间
    private LocalDateTime updateTime;// 用户修改的时间
}
