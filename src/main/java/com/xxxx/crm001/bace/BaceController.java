package com.xxxx.crm001.bace;

import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;

public class BaceController {
    @ModelAttribute
    public void preHander(HttpServletRequest request){
            request.setAttribute("ctx",request.getContextPath());

    }
    public ResultInfo success(){
        return new ResultInfo();
    }
    public ResultInfo success(String msg){
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setMsg(msg);
        return new ResultInfo();
    }
    public ResultInfo success(String msg, Object result){
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setMsg(msg);
        resultInfo.setResult(result);
        return new ResultInfo();
    }
}
