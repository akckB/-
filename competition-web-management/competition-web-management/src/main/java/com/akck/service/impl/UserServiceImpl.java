package com.akck.service.impl;

import com.akck.mapper.UserMapper;
import com.akck.pojo.User;
import com.akck.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(User user) {
        return userMapper.getByUsernameAndPassword(user);
    }

    @Override
    public Integer regist(User user) {
        user.setUpdateTime(LocalDateTime.now());
        user.setCreateTime(LocalDateTime.now());
        return userMapper.registUser(user);
    }

    @Override
    public Integer findByUsername(User user) {
        return userMapper.findByUser(user);
    }

    @Override
    public User findByUsernameGetUser(User u) {
        return userMapper.getUserInfo(u);
    }

    @Override
    public String update(User user) {
        user.setUpdateTime(LocalDateTime.now());
        if (user.getName() != null) {
            boolean matches = user.getName().matches("^(?:[\\u4e00-\\u9fa5·]{2,16})$");
            if (!matches) {
                return "姓名格式不正确 修改失败";
            }
        }
        if (user.getEmail() != null) {
            boolean matches = user.getEmail().matches("\\w+@\\w+\\.\\w{2,3}(\\.\\w{2,3})*");
            if (!matches) {
                return "邮箱格式不正确 修改失败";
            }
        }
        if (user.getPhonenumber() != null) {
            boolean matches = user.getPhonenumber().matches("^(?:(?:\\+|00)86)?1[3-9]\\d{9}$");
            if (!matches) {
                return "手机号码不合法 修改失败";
            }
        }
        userMapper.update(user);
        return "修改成功";
    }

    @Override
    public String updatePwd(Integer id, String oldPassword, String newPassword) {
        Integer i = userMapper.updatePwd(id, newPassword);
        if (i == 1) {
            return "修改成功";
        } else {
            return "修改失败";
        }
    }
}
