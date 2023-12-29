package com.akck.config;

import com.akck.interceptor.LoginCheckInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 定义拦截器的目标
 */
@Configuration//配置类
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private LoginCheckInterceptor loginCheckInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 登录接口和注册接口不拦截
        registry.addInterceptor(loginCheckInterceptor).excludePathPatterns("/users/login",
                "/register.html", "/favicon.ico", "/users/register", "/users/registr",
                "/HomePage.html", "/PersonalCenter.html", "/SignUpForAMatch.html",
                "/CompetitionManage.html", "/展示图.jpg","/js/axios.min.js","/js/axios.min.js.map");
    }
}
