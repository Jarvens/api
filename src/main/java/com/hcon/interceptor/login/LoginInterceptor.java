package com.hcon.interceptor.login;

import com.hcon.api.domain.UserRegister;
import com.hcon.common.Pair;
import com.hcon.consts.AuthConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;

/**
 * 系统平台 用户登录拦截器
 * Created by kunlun on 2017/3/29.
 */
public abstract class LoginInterceptor extends LoginVerifyInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    @Override
    protected boolean validUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Pair<Boolean, UserRegister> valid = validCookie();
        if (null == valid||!valid.getFirst()) {
            logger.info("用户未登录.......>");
            redirect2Login(request, response);
            return false;
        }
        UserRegister userRegister = valid.getSecond();
        long expireTime = userRegister.getCurrentTime() + AuthConstants.SYS.EXPIRE_SECONDS * 1000;
        long currentTimeInMillis = Calendar.getInstance().getTimeInMillis();
        if (currentTimeInMillis > expireTime) {
            logger.info("登录超时.........>");
            redirect2Login(request, response);
            return false;
        }
        userRegister.updateCurrentTime();

        return true;
    }
}
