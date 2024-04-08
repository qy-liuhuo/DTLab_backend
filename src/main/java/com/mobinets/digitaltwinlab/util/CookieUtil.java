package com.mobinets.digitaltwinlab.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieUtil {

    /**
     * 用于从request的cookie中提取信息
     * @param request
     * @param name 键
     * @return
     */
    public static String getValue(HttpServletRequest request, String name) {
        if(request == null || name == null) {
            throw new IllegalArgumentException("参数为空");
        }
        Cookie[] cookies = request.getCookies();
        if(cookies != null) {
            for(Cookie cookie:cookies){
                if(cookie.getName().equals(name)){
                    return cookie.getValue();
                }
            }
        }
        return null;
    }
}
