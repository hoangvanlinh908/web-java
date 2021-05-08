//package com.msita.demo.config;
//
//
//
//import com.msita.demo.interceptors.AuthorizedInterceptor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
//@Configuration
//
//public class WebMvcConfig extends WebMvcConfigurerAdapter {
//    @Autowired
//    private AuthorizedInterceptor authorizedInterceptor;
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        super.addInterceptors(registry);
//
//        registry.addInterceptor(authorizedInterceptor).excludePathPatterns("/login", "/register");
//    }
//
//
//}