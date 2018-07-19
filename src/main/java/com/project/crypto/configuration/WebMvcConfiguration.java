package com.project.crypto.configuration;

import com.project.crypto.interceptor.LogInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@Slf4j
public class WebMvcConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        log.info("Adding interceptor");
        registry.addInterceptor(new LogInterceptor()).addPathPatterns("/**");

        //       registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/login");
    }
}