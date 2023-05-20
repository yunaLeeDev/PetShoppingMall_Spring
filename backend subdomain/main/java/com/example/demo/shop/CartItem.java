package com.example.demo.shop;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class CartItem {
    
    
    //id라는 속성을 선언하고 Long type으로 지정해준다.
    @Id @GeneratedValue
    Long Id;

    //getter, setter를 만들어준다.
    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    //N:1의 관계로 manytoone의 성질을 지니는 customer형태의 객체를 만들어준다.
    @ManyToOne
    Customer customer;

    //getter, setter를 만들어준다.
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }



    //String 형의 pet 속성을 지정해준다.
    String pet;
    
    //getter, setter를 만들어준다.
    public String getPet() {
        return pet;
    }

    public void setPet(String pet) {
        this.pet = pet;
    }

    //Payment형의 객체를 생성해준다.
    @Embedded
    Payment payment;

   //getter, setter를 만들어준다.
    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }



}
