package com.xxxx.crm001.vo;

import com.xxxx.crm001.bace.BaceQuery;

public class SaleChanceVo extends BaceQuery {
    private String createMan;
    private String state;

    public String getCreateMan() {
        return createMan;
    }

    public void setCreateMan(String createMan) {
        this.createMan = createMan;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
