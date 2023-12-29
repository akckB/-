package com.akck.service;


import com.akck.pojo.User;

public interface UserService {

    /**
     * 用于实现用户登录操作的
     * @param user
     * @return
     */
    User login(User user);

    /**
     * 用于实现用户注册操作的
     *
     * @param user
     * @return
     */
    Integer regist(User user);


    /**
     * 根据用户名去查询用户
     * @return
     */
    Integer findByUsername(User user);

    /**
     * 根据用户名查询用户 然后获取用户全部信息
     * @param u
     */
    User findByUsernameGetUser(User u);

    /**
     * 跟新用户的个人信息
     *
     * @param user
     * @return
     */
    String update(User user);

    /**
     * 实现修改用户密码的操作
     *
     * @return
     */
    String updatePwd(Integer id, String oldPassword, String newPassword);

}
