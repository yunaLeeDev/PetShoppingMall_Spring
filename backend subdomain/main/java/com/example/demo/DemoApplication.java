package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@EnableAspectJAutoProxy
public class DemoApplication {
	public static void main(String[] args) {
		//Springboot를 실행한다.
		SpringApplication.run(DemoApplication.class, args);
	}
	

}
