package com.hcon.core.interceptor.login;

import com.alibaba.fastjson.JSON;
import com.hcon.api.domain.UserRegister;
import com.hcon.core.common.DataRet;
import com.hcon.consts.AuthConstants;
import com.hcon.core.interceptor.login.annotations.VerifyType;
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
public class LoginInterceptor extends LoginVerifyInterceptor {

    protected static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    @Override
    protected VerifyType getType() {
        return VerifyType.SYS;
    }

    @Override
    protected boolean validToken(HttpServletRequest request, HttpServletResponse response) throws Exception {
        DataRet<String> ret = new DataRet<>();
        String token = request.getHeader(AuthConstants.SYS.TOKEN_NAME);
        if (null == token || "".equals(token)) {
            ret.setErrorCode("permission_denied");
            ret.setMessage("请重新登录");
            response.getWriter().write(JSON.toJSONString(ret));
            return false;
        }
        UserRegister userRegister = new UserRegister();
        userRegister = JSON.parseObject(Aes.decrypt(token, AuthConstants.SYS.TOKEN_DECRYPT_KEY), UserRegister.class);
        if (null == userRegister) {
            ret.setErrorCode("permission_denied");
            ret.setMessage("请重新登录");
            response.getWriter().write(JSON.toJSONString(ret));
            return false;
        }
        long expireTime = userRegister.getCurrentTime() + AuthConstants.SYS.TOKEN_EXPIRE_SECONDS * 1000;
        long currentTimeInMillis = Calendar.getInstance().getTimeInMillis();
        if (currentTimeInMillis > expireTime) {
            logger.info("登录超时......");
            ret.setErrorCode("permission_denied");
            ret.setMessage("登录超时,请重新登录");
            response.getWriter().write(JSON.toJSONString(ret));
            return false;
        }
        userRegister.updateCurrentTime();
        return true;
    }

}
