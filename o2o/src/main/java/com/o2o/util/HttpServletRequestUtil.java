package com.o2o.util;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: yzy
 * @Date: 2018/10/12 10:50
 * @Description:
 */
public class HttpServletRequestUtil {
    //将request中的key值类型转换成int
    public static int getInt(HttpServletRequest request, String key) {
        try {
            return Integer.decode(request.getParameter(key));
        } catch (Exception e) {
            return -1;
        }
    }

    //将request中的key值类型转换成long
    public static long getLong(HttpServletRequest request, String key) {
        try {
            return Long.valueOf(request.getParameter(key));
        } catch (Exception e) {
            return -1;
        }
    }

    //将request中的key值类型转换成double
    public static double getDouble(HttpServletRequest request, String key) {
        try {
            return Double.valueOf(request.getParameter(key));
        } catch (Exception e) {
            return -1;
        }
    }

    //将request中的key值类型转换成boolean
    public static boolean getBoolean(HttpServletRequest request, String key) {
        try {
            return Boolean.valueOf(request.getParameter(key));
        } catch (Exception e) {
            return false;
        }
    }

    //将request中的key值类型转换成string
    public static String getString(HttpServletRequest request, String key) {
        try {
            String result = request.getParameter(key);
            if(result != null) {
                result = result.trim();
            }
            if ("".equals(result)) {
                result = null;
            }
            return result;
        } catch (Exception e) {
            return null;
        }
    }
}
