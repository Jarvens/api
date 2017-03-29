package com.hcon.interceptor.login.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 登录校验Action
 * Created by kunlun on 2017/3/29.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface LoginVerifyAction {
    VerifyType type() default VerifyType.SYS;
}
