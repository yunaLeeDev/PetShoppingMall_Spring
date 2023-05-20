package com.example.demo.shop;

public class Payment {

    
    //String형의 method를 만들어준다.
    String method;
    
    //String형의 status를 만들어준다.
    String status;

    
    //mehod의 getter, setter를 만들어준다.
    public String getMethod() {
        return method;
    }
    public void setMethod(String method) {
        this.method = method;
    }
    
    //status의 getter, setter를 만들어준다.
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    
}
