package com.xxxx.crm001.exception;

import com.xxxx.crm001.bace.ResultInfo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalException {
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ResultInfo exec (Exception e){
        System.out.println("进入到全局异常处理器！");
        ResultInfo resultInfo01 = new ResultInfo();
        if (e instanceof ParamsException){
            System.out.println("参数");
            resultInfo01.setCode(200001);
            resultInfo01.setMsg("参数异常");
            resultInfo01.setResult(((ParamsException) e).getMsg());
        }else if (e instanceof MyException){
            System.out.println("我的");
            resultInfo01.setCode(200002);
            resultInfo01.setMsg("我的异常");
            resultInfo01.setResult(((MyException) e).getMsg());
        }else if (e instanceof NullPointerException){
            System.out.println("空指针");
            resultInfo01.setCode(200003);
            resultInfo01.setMsg("空指针异常");
        } else if(e instanceof NoCookieException){
            resultInfo01.setCode(200004);
            resultInfo01.setMsg("没有cookie");
        }
        return resultInfo01;
    }
}
