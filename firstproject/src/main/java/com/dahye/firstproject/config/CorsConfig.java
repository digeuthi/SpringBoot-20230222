package com.dahye.firstproject.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration //스프링의 기본 설정할수 있도록 맞춰주는것. 막혀있는것을 바꿔준다.
public class CorsConfig implements WebMvcConfigurer{
    
    public void addCorsMappings(CorsRegistry registry){
        registry
            .addMapping/*어떤 패스에 대해서 허용할건지 적어주는것*/("/**") // '*'' 을 사용하면 전부 허용하는것이란 뜻이다
            .allowedMethods/*어떤 메서드에 대해서 허용할건지?*/("*")
            .allowedOrigins/*어떤 출처에 대해서 허용할건지에 대한것 적어줌*/("*"); //웹개발을 위한 용도로 만들겠다할때 그것만 만들고할때 사용
    }
}
