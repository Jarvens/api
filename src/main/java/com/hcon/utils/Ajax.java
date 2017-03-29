package com.hcon.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by kunlun on 2017/3/29.
 */
public class Ajax {
    public static boolean isAjax(HttpServletRequest request) {
        return "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));
    }
}
