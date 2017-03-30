package com.hcon.utils;

import com.alibaba.fastjson.JSON;
import com.hcon.api.domain.UserRegister;
import com.hcon.common.Cookies;
import com.hcon.common.HconAes;
import com.hcon.consts.AuthConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

/**
 * 登录帮助类
 * Created by kunlun on 2017/3/29.
 */
public class LoginHelper {

    private static final Logger logger = LoggerFactory.getLogger(LoginHelper.class);

    //cookie
    private static Cookies cookies = new Cookies();

    //加密 &  解密
    private static HconAes hconAes = new HconAes();

    public static void sysLoginSuccess(HttpServletResponse response, UserRegister userRegister, boolean authLogin) {
        loginSuccess(response, userRegister, AuthConstants.SYS.COOKIE_NAME, authLogin);
    }

    private static void loginSuccess(HttpServletResponse response, UserRegister userRegister, String cookieName, boolean authLogin) {
        if (!StringUtils.hasLength(userRegister.getAccount())) {
            logger.info("Unable to read Account.......");
            return;
        }
        userRegister.updateCurrentTime();
        String cookieStr = Aes.encrypt(JSON.toJSONString(userRegister), AuthConstants.SYS.COOKIE_DECRYPT_KEY);
        logger.info("cookie is ..........>", cookieName, cookieStr);
        //判断是否为自动登录
        if (authLogin) {
            //cookies.addCookie(response,AuthConstants.)
        } else {
            cookies.addCookie(response, cookieName, cookieStr, AuthConstants.SYS.EXPIRE_SECONDS, TimeUnit.SECONDS);
        }

        clearAuthFail(response);
    }


    /**
     * 登录成功后，清空失败记录
     *
     * @param response
     */
    private static void clearAuthFail(HttpServletResponse response) {
        cookies.delCookie(response, AuthConstants.HCON_AUTH_FAIL);
    }

}
