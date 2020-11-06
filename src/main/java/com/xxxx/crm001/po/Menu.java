package com.xxxx.crm001.po;

import java.util.List;

public class Menu {
    private Integer id;
    private String menuName;
    private Integer pid;

    private List<Menu> list;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMeanName() {
        return menuName;
    }

    public void setMeanName(String meanName) {
        this.menuName = meanName;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public List<Menu> getList() {
        return list;
    }

    public void setList(List<Menu> list) {
        this.list = list;
    }
}