package com.xxxx.crm001.controller;

import com.xxxx.crm001.po.SaleChamce;
import com.xxxx.crm001.service.SaleChanceService;
import com.xxxx.crm001.vo.SaleChanceVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("sale_chance")
public class SaleChanceController {
    @Autowired
    private SaleChanceService saleChanceService;

    @RequestMapping("index")
    public String index(){
        return "saleChance/sale_chance";
    }
    @RequestMapping("list")
    @ResponseBody
    public Map<String,Object> list(SaleChanceVo vo){
        Map<String,Object> map = saleChanceService.selectList(vo);
        return map;
    }
}
