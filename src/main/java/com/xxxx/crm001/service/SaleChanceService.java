package com.xxxx.crm001.service;

import com.xxxx.crm001.po.SaleChamce;
import com.xxxx.crm001.vo.SaleChanceVo;


import java.util.Map;

public interface SaleChanceService {
    Map<String,Object> selectList(SaleChanceVo vo);
}
