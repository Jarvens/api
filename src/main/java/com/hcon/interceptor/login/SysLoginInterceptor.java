package com.hcon.interceptor.login;

import com.hcon.api.domain.UserRegister;
import com.hcon.common.Pair;
import com.hcon.common.Security;
import com.hcon.interceptor.login.annotations.VerifyType;

/**
 * Created by kunlun on 2017/3/29.
 */
public class SysLoginInterceptor extends LoginInterceptor {
    @Override
    protected VerifyType getType() {
        return VerifyType.SYS;
    }

    @Override
    protected <T> Pair<Boolean, T> validCookie() {
        UserRegister userRegister = Security.getSysUser();
        logger.info("解析user对象为:{}", userRegister);
        if (null == userRegister) {
            return new Pair(false, null);
        }

        return new Pair(true, userRegister);
    }
}
