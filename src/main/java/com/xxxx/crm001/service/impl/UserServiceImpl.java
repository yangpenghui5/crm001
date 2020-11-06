package com.xxxx.crm001.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xxxx.crm001.dao.UserDao;
import com.xxxx.crm001.exception.MyException;
import com.xxxx.crm001.exception.ParamsException;
import com.xxxx.crm001.po.User;
import com.xxxx.crm001.po.UserVo;
import com.xxxx.crm001.service.UserService;
import com.xxxx.crm001.utils.Md5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@SuppressWarnings("all")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User selectUserByUserNameAndPwd(String userName, String userPwd) throws ParamsException, MyException {
        if (userName == null || "".equals(userName.trim())) {
            throw new ParamsException(2000, "用户名不能为空！");
        }
        if (userPwd == null || "".equals(userPwd.trim())) {
            throw new ParamsException(2000, "用户密码不能为空！");
        }
        User user =  userDao.selectUserByName(userName);
        if(user==null){
        throw new MyException("用户名不存在");
        }
        String userPwd1 = user.getUserPwd();
        String code = Md5Utils.encode(userPwd);
        if (!userPwd1.equals(code)){
            throw new MyException("用户密码错误！");
        }
        return user;
    }

    @Override
    public void updatePwd(String id, String oldPwd, String newPwd, String repeatPwd) throws ParamsException, MyException {
        if(oldPwd==null || "".equals(oldPwd.trim())){
            System.out.println("旧密码不能为空！");
            throw new ParamsException(2000,"旧密码不能为空");
        }
        if(!newPwd.equals(repeatPwd)){
            System.out.println("确认密码与新密码不同！");
            throw new MyException("确认密码与新密码不同");
        }
        User u = userDao.selectUserById(id);
        String ecode = Md5Utils.encode(oldPwd);

        String userPwd = u.getUserPwd();

        if(!userPwd.equals(ecode)){
            System.out.println("旧密码错误！");
            return;
        }
        userDao.updateUserPwd(id,Md5Utils.encode(newPwd));
    }

    @Override
    public Map<String, Object> selectList(UserVo vo) {
        PageHelper.startPage(vo.getPage(), vo.getLimit());
        //
        List<User> list = userDao.selectList(vo);
        PageInfo<User> pageInfo = new PageInfo<>(list);


        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", pageInfo.getTotal());
        map.put("data", list);
        return map;
    }

    @Override
    public void insertUser(User user) {
        String pwd = "123";
        String encode = Md5Utils.encode(pwd);

        user.setUserPwd(encode);
        user.setIsValid(1);
        user.setCreateDate(new Date());
        userDao.insertUser(user);
    }

    @Override
    public User selectUserById(String id) {
        User user = userDao.selectUserById(id);
        return user;
    }

    @Override
    public void updateUser(User user) {
        user.setCreateDate(new Date());
        userDao.updateUser(user);
    }

    @Override
    public void deleteUser(List<String> ids) {
        userDao.deleteUser(ids);
    }
}
