package com.example.demo;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HomeAdvice {
    
    //integer형의 pageview 속성을 정의한다. 
    static int pageview = 0; 
    //getpageview하면 return해 pageview를 전달한다.
    public static int getPageView(){
        return pageview;
    }

    //업로드가 끝난 후에 after 메소드를 사용한다.
    @After("execution(* com.example.demo.DemoApplication.*(..))")
    public void after(){
        //"page view : "와 함께 pageview를 1씩 증가시켜준다. 그리고 출력한다.
        System.out.println("page view : " + (++pageview));
    }
}
