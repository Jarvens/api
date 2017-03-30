package com.hcon.interceptor.login;

import com.alibaba.fastjson.JSON;
import com.hcon.api.domain.UserRegister;
import com.hcon.common.Pair;
import com.hcon.consts.AuthConstants;
import com.hcon.utils.Aes;
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

    protected static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    @Override
    protected boolean validUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.info("request信息包含请求头token:{}", request.getHeader(AuthConstants.SYS.TOKEN_NAME));
        String token = request.getHeader(AuthConstants.SYS.TOKEN_NAME);

        UserRegister userRegister = new UserRegister();
        userRegister = JSON.parseObject(Aes.decrypt(token, AuthConstants.SYS.TOKEN_DECRYPT_KEY), UserRegister.class);
        if (null == userRegister) {
            redirect2Login(request, response);
            return false;
        }
        long expireTime = userRegister.getCurrentTime() + AuthConstants.SYS.TOKEN_EXPIRE_SECONDS * 1000;
        long currentTimeInMillis = Calendar.getInstance().getTimeInMillis();
        if (currentTimeInMillis > expireTime) {
            logger.info("登录超时......");
            redirect2Login(request, response);
            return false;
        }
        userRegister.updateCurrentTime();
        return true;
    }
}
