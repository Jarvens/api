package com.hcon.interceptor.login;

import com.alibaba.fastjson.JSON;
import com.hcon.common.Pair;
import com.hcon.interceptor.login.annotations.VerifyType;
import com.hcon.utils.Ajax;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录校验拦截器
 * Created by kunlun on 2017/3/29.
 */
public abstract class LoginVerifyInterceptor extends HandlerInterceptorAdapter {

    private static final Logger logger = LoggerFactory.getLogger(LoginVerifyInterceptor.class);

    //重定向URL
    protected String REDIRECT_URL = "";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        REDIRECT_URL = request.getServletPath();
        if (request.getQueryString() != null) {
            REDIRECT_URL += "?" + request.getQueryString();
        }

        logger.info("RequestUri........>", REDIRECT_URL);
        logger.info("Request.........>", JSON.toJSONString(request.getQueryString()));
        try {
            if (!LoginVerifyHelper.needVerifyLogin(handler, getType())) {
                return true;
            }
            return validUser(request, response);
        } catch (Exception e) {
            logger.info("登录校验失败......>", e);

        }
        return super.preHandle(request, response, handler);
    }

    //校验类型
    protected abstract VerifyType getType();

    //用户信息校验
    protected abstract boolean validUser(HttpServletRequest request, HttpServletResponse response) throws Exception;

    //Cookie校验
    protected abstract <T> Pair<Boolean, T> validCookie();

    /**
     * 重定向 登录
     *
     * @param request
     * @param response
     */
    protected void redirect2Login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect(request.getContextPath() + "/sys/retry");
    }

}
