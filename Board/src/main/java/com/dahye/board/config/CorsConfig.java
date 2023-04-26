package com.dahye.board.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    //다른 출처에서 자원을 공유에대한 출처를 리소스를 공유할때 권한을 정의
    public void addCorsMappings(CorsRegistry registry) {
        registry
        .addMapping("/**")
        .allowedOrigins("*") //모든출처에 대해 허용
        .allowedMethods("*"); //모든 메서드에 대해 적용하겠다. 
    }
}
