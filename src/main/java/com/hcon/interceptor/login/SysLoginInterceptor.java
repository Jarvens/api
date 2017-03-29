package com.hcon.interceptor.login;

import com.hcon.api.domain.UserRegister;
import com.hcon.common.Pair;
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
        UserRegister userRegister = new UserRegister();
        return null;
    }
}
