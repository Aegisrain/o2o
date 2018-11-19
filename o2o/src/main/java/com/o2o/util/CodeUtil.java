package com.o2o.util;

import com.google.code.kaptcha.Constants;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: yzy
 * @Date: 2018/11/4 13:40
 * @Description:判断验证码是否正确
 */
public class CodeUtil {
    public static boolean checkVerfiyCode (HttpServletRequest request) {
        String verfiyCodeExpected = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        String verfiyCodeActual = HttpServletRequestUtil.getString(request, "verfiyCodeActual");
        if (verfiyCodeActual == null || !verfiyCodeActual.equals(verfiyCodeExpected)) {
            return false;
        }
        return true;
    }
}
