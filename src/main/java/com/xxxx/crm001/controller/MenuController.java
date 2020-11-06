package com.xxxx.crm001.controller;

import com.xxxx.crm001.bace.BaceController;
import com.xxxx.crm001.bace.ResultInfo;
import com.xxxx.crm001.po.Menu;
import com.xxxx.crm001.service.MenuService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("menu")
public class MenuController extends BaceController {
    @Autowired
    private MenuService menuService;

    @RequestMapping("list")
    public ResultInfo selectList(){
        List<Menu> list = menuService.selectList();

        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setCode(200);
        resultInfo.setMsg("菜单");
        resultInfo.setResult(list);

        return resultInfo;
    }
    @RequestMapping("queryMenuById")

    public List<Menu> queryMenuById(Integer id){
        List list = menuService.queryMenuById(id);
        return list;
    }

    @RequestMapping("updateUserRole")

    public ResultInfo updateUserRole(String userId,String[] roleIds){

        menuService.updateUserRole(userId,roleIds);
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setCode(200);
        return resultInfo;
    }

    @RequestMapping("updateRoleMenu")
    public ResultInfo updateRoleMenu(String roleId,String[] menuIds){

        menuService.updateRoleMenu(roleId,menuIds);
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setCode(200);
        return resultInfo;
    }
}
