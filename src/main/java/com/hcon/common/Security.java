package com.hcon.common;

import com.alibaba.fastjson.JSON;
import com.hcon.api.domain.UserRegister;
import com.hcon.consts.AuthConstants;
import com.hcon.utils.Aes;
import com.hcon.utils.HconUtils;
import org.apache.commons.lang3.StringUtils;
import org.n3r.eql.util.T;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by kunlun on 2017/3/29.
 */
public class Security {

    private static final Logger logger = LoggerFactory.getLogger(Security.class);

    public static Cookies cookies = new Cookies();


    public static UserRegister getSysUser() {
        return getLoginUser(HconUtils.getRequest(), AuthConstants.SYS.COOKIE_NAME, UserRegister.class);
    }

    /**
     * 从cookie获取登录信息
     *
     * @param request
     * @param cookieName
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getLoginUser(HttpServletRequest request, String cookieName, Class<T> clazz) {
        String cookieStr = cookies.getCookie(request, cookieName);
        logger.info("匹配Cookie内容为:{}", cookieStr);
        if (StringUtils.isEmpty(cookieStr)) {
            return null;
        }
        //对Cookie进行解密
        String cookieDecryptStr = Aes.decrypt(cookieStr, AuthConstants.SYS.COOKIE_DECRYPT_KEY);
        if (StringUtils.isEmpty(cookieDecryptStr)) {
            logger.info("解密Cookie信息为空,密文:{}", cookieStr);
            return null;
        }
        T user = JSON.parseObject(cookieDecryptStr, clazz);
        return user;
    }

}
