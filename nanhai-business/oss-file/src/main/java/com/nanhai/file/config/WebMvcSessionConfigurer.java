package com.nanhai.file.config;

import com.nanhai.core.framework.object.RibbonInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截器配置类
 */
@Configuration
public class WebMvcSessionConfigurer implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用于排除拦截
        // old: new RedisSessionInterceptor()
        // registry.addInterceptor(ribbonInterceptor).addPathPatterns("/**");
        registry.addInterceptor(new RibbonInterceptor()).addPathPatterns("/**");
    }
}
