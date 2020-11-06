package com.xxxx.crm001.service;



import com.xxxx.crm001.po.Menu;

import java.util.List;

public interface MenuService {
    List<Menu> selectList();

    List<Menu> queryMenuById(Integer id);

    void updateUserRole(String userId, String[] roleIds);

    void updateRoleMenu(String roleId, String[] menuIds);
}
