package com.xxxx.crm001.dao;


import com.xxxx.crm001.po.Menu;
import com.xxxx.crm001.po.RoleMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuDao {

    List<Menu> selectList();

    List<Menu> queryMenuById(Integer id);

    void deleteUserRole(String userId);

    void insertUserRole(@Param("userId") String userId,@Param("array") String[] roleIds);

    void deleteRoleMenu(String roleId);

    void insertRoleMenu(@Param("list") List<RoleMenu> list);
}
