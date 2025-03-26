package com.coletas.coletas.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(@NonNull CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("https://frontend-projeto-coletas.vercel.app", "http://localhost:3000") 
                .allowedMethods("*")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}
