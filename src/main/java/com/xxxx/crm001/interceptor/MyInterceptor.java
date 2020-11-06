package com.xxxx.crm001.interceptor;

import com.xxxx.crm001.exception.NoCookieException;
import com.xxxx.crm001.utils.GetCookieFromRequest;
import com.xxxx.crm001.exception.NoCookieException;
import com.xxxx.crm001.utils.GetCookieFromRequest;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 实现自定义的拦截器
 */
public class  MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setAttribute("ctx", request.getContextPath());
        String id = GetCookieFromRequest.getValueFromCookieByName(request, "id");
        if(id ==null || "".equals(id)){
            throw new NoCookieException("没有cookie");
        }
        return true;
    }
}
