package com.akck.mapper;

import com.akck.pojo.Result;
import com.akck.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {

    /**
     * 根据用户名和密码来查询用户 作为登录的标准
     *
     * @param user
     * @return
     */
    @Select("select * from user where username = #{username} and password = #{password}")
    User getByUsernameAndPassword(User user);

    /**
     * 注册用户的操作
     *
     * @param user
     * @return
     */
    @Insert("insert into user(username,password,role,create_time,update_time) values (#{username},#{password},#{role},#{createTime},#{updateTime})")
    Integer registUser(User user);


    @Select("select count(*)  from user where username=#{username}")
    Integer findByUser(User user);

    @Select("select * from user where username =#{username}")
    User getUserInfo(User u);

    void update(User user);

    @Update("update user set password = #{newPassword} where id=#{id}")
    Integer updatePwd(Integer id, String newPassword);
}
