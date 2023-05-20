package com.example.demo.shop;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
    //String형의 detail 속성을 만들어준다.
    String detail;
    //String형의 zipcode 속성을 만들어준다.
    String zipcode;

    //Detail의 getter setter를 지정해준다.
    public String getDetail() {
        return detail;
    }
    public void setDetail(String detail) {
        this.detail = detail;
    }
    //zipcode의 getter setter를 지정해준다.
    public String getZipcode() {
        return zipcode;
    }
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
    
}
