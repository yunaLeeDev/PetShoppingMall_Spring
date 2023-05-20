package com.example.demo.shop;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {
    //String형의 id를 만들어준다.
    @Id
    String id;

    //address 객체를 만들어준다.
    @Embedded
    Address address;
    
    //id의 getter, setter를 만들어준다.
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    
    //address의 getter, setter를 만들어준다.
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    
}
