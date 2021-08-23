package com.liurui.meme.api.core.config;

import com.liurui.meme.api.core.interceptor.UserContextInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @description 拦截器, 转发等各种配置添加注册的地方
 * @author 渣渣瑞
 */
@Configuration
public class WebConfigurer implements WebMvcConfigurer {

    @Autowired
    private UserContextInterceptor userContextInterceptor;

    /**
     * 添加CROS（跨域资源共享）
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins("https://www.demo.com")
                .allowedHeaders("head1")
                .exposedHeaders("head1")
                .allowedMethods("GET", "POST")
                .allowCredentials(true)
                .maxAge(60 * 60);
    }

    /**
     * 添加过滤器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userContextInterceptor).addPathPatterns("/");
    }
}
