package com.xxxx.crm001.service;


import com.xxxx.crm001.exception.MyException;
import com.xxxx.crm001.exception.ParamsException;
import com.xxxx.crm001.po.User;
import com.xxxx.crm001.po.UserVo;

import java.util.List;
import java.util.Map;

public interface UserService {
    User selectUserByUserNameAndPwd (String userName, String userPwd) throws ParamsException, MyException;
    void updatePwd(String id,String oldPwd, String newPwd, String repeatPwd)throws ParamsException,MyException;

    Map<String, Object> selectList(UserVo vo);

    void insertUser(User user);

    User selectUserById(String id);

    void updateUser(User user);


    void deleteUser(List<String> ids);
}
