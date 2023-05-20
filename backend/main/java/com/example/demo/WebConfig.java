package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//웹과 관련된 처리를 위해 WebMvcConfigurer interface를 다중상속해온다.
@Configuration
public class WebConfig implements WebMvcConfigurer {

  //addCorsMappings를 overide해와 사용한다.
  @Override
  public void addCorsMappings(CorsRegistry registry) {
    ///pets라고 URL 패턴을 정의해준다.
    registry.addMapping("/pets")
    //자원 공유를 허락할 origin을 "http://localhost:8081"라고 지정한다.
        .allowedOrigins("http://localhost:8081");
  }
}

