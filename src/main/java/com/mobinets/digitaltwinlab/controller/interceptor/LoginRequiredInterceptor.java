package com.mobinets.digitaltwinlab.controller.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.mobinets.digitaltwinlab.annotation.LoginRequired;
import com.mobinets.digitaltwinlab.util.HostHolder;
import com.mobinets.digitaltwinlab.util.response.Response;
import com.mobinets.digitaltwinlab.util.response.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.lang.reflect.Method;


/**
 * 登录条件拦截器，拦截未登录状态下的越权请求
 */
@Component
public class LoginRequiredInterceptor implements HandlerInterceptor {

    @Autowired
    private HostHolder hostHolder;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            LoginRequired loginRequired = method.getAnnotation(LoginRequired.class);
            //带有需要登录的注解，且hostHolder中拿不到user
            if(loginRequired != null && hostHolder.getUser() == null) {
                Response r=Response.failure(ResponseCode.NOT_LOGGED_IN);
                response.setStatus(200);
                response.setCharacterEncoding("UTF-8");
                response.setContentType("application/json");
                PrintWriter writer = response.getWriter();
                writer.write(JSONObject.toJSONString(r));
                writer.close();
                return false;
            }
        }
        return true;
    }
}
