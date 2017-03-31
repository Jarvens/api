package com.hcon.core.common;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by Lionel on 15/11/12.
 */
public class Reflect {

    public static Type getGenericTypeArgument(Method method) {
        Type genericReturnType = method.getGenericReturnType();
        return getGenericTypeArgument(genericReturnType);
    }

    public static Type getGenericTypeArgument(Type genericReturnType) {
        if (!(genericReturnType instanceof ParameterizedType)) return null;

        ParameterizedType parameterizedType = (ParameterizedType) genericReturnType;
        return parameterizedType.getActualTypeArguments()[0];
    }
}
