package com.xxxx.crm001.dao;


import com.xxxx.crm001.po.User;
import com.xxxx.crm001.po.UserVo;

import java.util.List;

public interface UserDao {
    User selectUserByName(String userName);

    User selectUserById(String id);

    void updateUserPwd(String id,String userPwd);

    List<User> selectList(UserVo vo);

    void insertUser(User user);

    void updateUser(User user);

    void deleteUser(List<String> ids);
}
