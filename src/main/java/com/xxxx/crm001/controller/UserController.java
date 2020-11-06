package com.xxxx.crm001.controller;

import com.xxxx.crm001.bace.BaceController;
import com.xxxx.crm001.bace.ResultInfo;
import com.xxxx.crm001.exception.MyException;
import com.xxxx.crm001.exception.ParamsException;
import com.xxxx.crm001.po.User;
import com.xxxx.crm001.po.UserVo;
import com.xxxx.crm001.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("user")
public class UserController extends BaceController {
    @Resource
    private UserService userService;
    @RequestMapping("toPasswordPage")
    public String toPasswordPage(){
        return "user/password";
    }

    @RequestMapping("index")
    public String index(){
        return "user/user";
    }

    @RequestMapping("addOrUpdateUserPage")
    public String addOrUpdateUserPage(HttpServletRequest request,String id){
        if (id!=null && !"".equals(id)){
            User u = userService.selectUserById(id);
            request.setAttribute("user",u);
        }
        return "user/add_update";
    }

    @RequestMapping("list")
    @ResponseBody
    public Map<String, Object> selectList(UserVo vo){
        Map<String, Object> map = userService.selectList(vo);
        return map;
    }

    @RequestMapping("login")
    @ResponseBody
    public ResultInfo login(String userName,String userPwd) throws MyException, ParamsException {
//            User u = null;
//        try {
//            u = userService.selectUserByUserNameAndPwd(userName,userPwd);
//        } catch (ParamsException e) {
//            e.printStackTrace();
//            ResultInfo resultInfo = new ResultInfo();
//            resultInfo.setCode(400);
//            resultInfo.setMsg(e.getMsg());
//            return resultInfo;
//        } catch (MyException e) {
//            e.printStackTrace();
//            ResultInfo resultInfo = new ResultInfo();
//            resultInfo.setCode(400);
//            resultInfo.setMsg(e.getMsg());
//            return resultInfo;
//        }
        User u = userService.selectUserByUserNameAndPwd(userName,userPwd);
            ResultInfo resultInfo = new ResultInfo();
            resultInfo.setCode(200);
            resultInfo.setMsg("");
            resultInfo.setResult(u);
            return resultInfo;
    }
    @ResponseBody
    @RequestMapping("updatePwd")
    public ResultInfo updatePwd(HttpServletRequest request,String oldPwd,String newPwd,String repeatPwd){
        String id = "";
        Cookie[] cookies = request.getCookies();
        for(int i = 0;i <cookies.length;i++){
            Cookie cookie = cookies[i];
            if (cookie.getName().equals("id")){
                id = cookie.getValue();
            }
        }
        try {
            userService.updatePwd(id,oldPwd,newPwd,repeatPwd);
        } catch (ParamsException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
        return null;
    }
    @RequestMapping("add")
    @ResponseBody
    public ResultInfo insertUser(User user){
        userService.insertUser(user);
        return success();
    }

    @RequestMapping("update")
    @ResponseBody
    public ResultInfo updateUser(User user){
        userService.updateUser(user);
        return success();
    }

    @RequestMapping("delete")
    @ResponseBody
    public ResultInfo deleteUser(@RequestParam List<String> ids){
        userService.deleteUser(ids);
        return success();
    }
}
