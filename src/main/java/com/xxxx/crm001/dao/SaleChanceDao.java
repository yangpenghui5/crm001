package com.xxxx.crm001.dao;

import com.xxxx.crm001.po.SaleChamce;
import com.xxxx.crm001.vo.SaleChanceVo;

import java.util.List;


public interface SaleChanceDao {
    List<SaleChamce> selectList(SaleChanceVo vo);
}
