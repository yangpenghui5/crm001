package com.xxxx.crm001.service.impl;

import com.xxxx.crm001.dao.MenuDao;
import com.xxxx.crm001.po.Menu;
import com.xxxx.crm001.po.RoleMenu;
import com.xxxx.crm001.service.MenuService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService{
    @Autowired
    private MenuDao menuDao;
    @Override
    public List<Menu> selectList() {
        List<Menu> list = menuDao.selectList();

        return list;

    }

    @Override
    public List<Menu> queryMenuById(Integer id) {

        List<Menu> list = menuDao.queryMenuById(id);
        return list;
    }

    @Override
    public void updateUserRole(String userId, String[] roleIds) {

        menuDao.deleteUserRole(userId);

        menuDao.insertUserRole(userId,roleIds);
    }

    @Override
    public void updateRoleMenu(String roleId, String[] menuIds) {

        menuDao.deleteRoleMenu(roleId);


        List<RoleMenu> lists = new ArrayList<>();
        for (int i = 0; i<menuIds.length; i++){
            RoleMenu roleMenu = new RoleMenu();
            roleMenu.setRoleId(Integer.valueOf(roleId));
            roleMenu.setMenuId(Integer.valueOf(menuIds[i]));

            lists.add(roleMenu);
  }
        lists.forEach(i -> {
            System.out.println(i.getRoleId() + "\t" + i.getMenuId());
        });

        menuDao.insertRoleMenu(lists);
    }
}

