package com.hcon.interceptor.login;

import com.hcon.interceptor.login.annotations.LoginVerifyAction;
import com.hcon.interceptor.login.annotations.NoCheckLoginMethod;
import com.hcon.interceptor.login.annotations.VerifyType;
import org.springframework.web.method.HandlerMethod;

import java.lang.reflect.Method;

/**
 * 登录校验帮助类
 * Created by kunlun on 2017/3/29.
 */
public class LoginVerifyHelper {

    /**
     * 是否需要登录校验
     *
     * @param loginVerifyAction
     * @param verifyType
     * @return true :需要   false:不需要
     */
    public static boolean needLoginVerifyAction(LoginVerifyAction loginVerifyAction, VerifyType verifyType) {
        if (loginVerifyAction != null && loginVerifyAction.type().equals(verifyType)) {
            return true;
        }
        return false;
    }

    /**
     * 是否需要登录校验的method
     *
     * @param method
     * @return
     */
    public static boolean needLoginVerifyMethod(Method method) throws SecurityException, NoSuchMethodException {
        NoCheckLoginMethod noCheckLoginMethod = method.getAnnotation(NoCheckLoginMethod.class);
        if (noCheckLoginMethod == null) {
            return true;
        }
        return false;
    }

    /**
     * 是否需要检验是否已登录
     *
     * @param handler
     * @param verifyType
     * @return
     * @throws NoSuchMethodException
     */
    public static boolean needVerifyLogin(Object handler, VerifyType verifyType) throws NoSuchMethodException {
        Class<? extends Object> clazz;
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            clazz = handlerMethod.getBeanType();
            if (!LoginVerifyHelper.needLoginVerifyMethod(handlerMethod.getMethod())) {
                return false;
            }
            LoginVerifyAction loginVerifyAction = clazz.getAnnotation(LoginVerifyAction.class);
            if (!LoginVerifyHelper.needLoginVerifyAction(loginVerifyAction, verifyType)) {
                return false;
            }
            return true;
        }
        return false;
    }
}
