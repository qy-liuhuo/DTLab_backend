package com.mobinets.digitaltwinlab.config;

import com.mobinets.digitaltwinlab.controller.interceptor.AlphaInterceptor;
import com.mobinets.digitaltwinlab.controller.interceptor.LoginRequiredInterceptor;
import com.mobinets.digitaltwinlab.controller.interceptor.LoginTicketInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private AlphaInterceptor alphaInterceptor;

    @Autowired
    private LoginTicketInterceptor loginTicketInterceptor;

    @Autowired
    private LoginRequiredInterceptor loginRequiredInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//去除此部分注释的话就会打日志
//        registry.addInterceptor(alphaInterceptor)
//                .excludePathPatterns("/**/*.css","/**/*.js","/**/*.png","/**/*.jpg","/**/*.jpeg")
//                .addPathPatterns(("/*/**"));
////                .addPathPatterns("/register","/login");

        //说明哪些部分需要添加权限验证拦截器
        registry.addInterceptor(loginTicketInterceptor)
                .excludePathPatterns("/**/*.css","/**/*.js","/**/*.png","/**/*.jpg","/**/*.jpeg")
                .addPathPatterns("/user/**")
                .addPathPatterns("/model/uploadModelFile")
                .addPathPatterns("/model/getAllModels")
                .addPathPatterns("/deviceLog/clearLog").addPathPatterns("/deviceLog/getMyLog").addPathPatterns("/permissionApplication/*");
        //说明哪些部分需要添加登录条件拦截器
        registry.addInterceptor(loginRequiredInterceptor)
                .excludePathPatterns("/**/*.css","/**/*.js","/**/*.png","/**/*.jpg","/**/*.jpeg")
                .addPathPatterns("/*/**");
    }


}
