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

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try {
            if (!LoginVerifyHelper.needVerifyLogin(handler, getType())) {
                return true;
            }
            return validToken(request, response);
        } catch (Exception e) {
            logger.info("登录校验失败......>", e);

        }
        return super.preHandle(request, response, handler);
    }

    //校验类型
    protected abstract VerifyType getType();

    //token校验
    protected abstract boolean validToken(HttpServletRequest request, HttpServletResponse response) throws Exception;

//    /**
//     * 重定向 登录
//     *
//     * @param request
//     * @param response
//     */
//    protected void permissionDenied(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        response.sendRedirect(request.getContextPath() + "/sys/permission-denied");
//    }

}
