package com.akck.controller;


import com.akck.anno.Log;
import com.akck.pojo.Result;
import com.akck.pojo.User;
import com.akck.service.UserService;
import com.akck.utils.JwtUtils;
import com.akck.utils.ThreadLocalUtil;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户注册操作
     *
     * @param user
     * @return
     */
    @PostMapping("/register")
    public Result registUser(@RequestBody User user) {
        // 参数校验 用户名 3 到 16 个 密码 5 到 16 个
        String username = user.getUsername();
        String password = user.getPassword();
        if (username != null && username.length() >= 3 &&
                username.length() <= 16
                && password != null &&
                password.length() >= 5 &&
                password.length() <= 16) {
            Integer index = userService.findByUsername(user);
            if (index == 1) {// 为一说明被占用了
                return Result.error("用户名已被占用");
            } else {
                userService.regist(user);
                return Result.success();
            }
        } else {
            return Result.error("参数不合法");
        }
    }

    /**
     * 用户登录操作
     *
     * @param user
     * @return
     */
    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        User user1 = userService.login(user);
        if (user1 == null) {
            return Result.error("用户名或密码错误");
        } else {
            HashMap<String, Object> claims = new HashMap<>();
            // 声明 添加到令牌上什么数据
            claims.put("id", user1.getId());
            claims.put("username", user1.getUsername());
            claims.put("name", user1.getName());
            claims.put("role", user1.getRole());
            String token = JwtUtils.generateJwt(claims);
            return Result.success(token);
        }
    }

    /**
     * 查询登录用户的个人信息
     *
     * @return
     */
    @GetMapping("/info")
    public Result userInfo() {
        String token = ThreadLocalUtil.get();
        Claims claims = JwtUtils.parseJWT(token);
        // 使用claims方法获取对象的信息
        String username = (String) claims.get("username");
        log.info(username);
        User u = new User();
        u.setUsername(username);
        User user = userService.findByUsernameGetUser(u);
        return Result.success(user);
    }

    /**
     * 修改用户的个人信息
     *
     * @param user
     * @return
     */
    @Log
    @PutMapping("/update")
    public Result update(@RequestBody @Validated User user) {
        String token = ThreadLocalUtil.get();
        Claims claims = JwtUtils.parseJWT(token);
        // 使用claims方法获取对象的信息
        Integer id = (Integer) claims.get("id");
        user.setId(id);
        String update = userService.update(user);
        return Result.success(update);
    }

    /**
     * 修改密码的接口
     */
    @PatchMapping("/updatePwd")
    public Result updatePwd(@RequestParam String oldPassword, @RequestParam String newPassword) {
        String token = ThreadLocalUtil.get();
        Claims claims = JwtUtils.parseJWT(token);
        // 使用claims方法获取对象的信息
        Integer id = (Integer) claims.get("id");
        // 返回修改密码是否成功
        String flog = userService.updatePwd(id, oldPassword, newPassword);
        return Result.success(flog);
    }
}
