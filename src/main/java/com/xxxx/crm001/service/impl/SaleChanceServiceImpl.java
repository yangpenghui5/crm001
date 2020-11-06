package com.xxxx.crm001.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xxxx.crm001.dao.SaleChanceDao;
import com.xxxx.crm001.po.SaleChamce;
import com.xxxx.crm001.service.SaleChanceService;
import com.xxxx.crm001.vo.SaleChanceVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service

public class SaleChanceServiceImpl implements SaleChanceService {
    @Resource
    private SaleChanceDao saleChanceDao;
    @Override
    public Map<String,Object> selectList(SaleChanceVo vo) {
        PageHelper.startPage(vo.getPage(),vo.getLimit());
        List<SaleChamce> list = saleChanceDao.selectList(vo);
        PageInfo<SaleChamce> pageInfo = new PageInfo<>(list);
        Map<String, Object> map = new HashMap();
        map.put("code",0);
        map.put("msg","");
        map.put("count", pageInfo.getTotal());
        map.put("data",list);
        return map;
    }
}
