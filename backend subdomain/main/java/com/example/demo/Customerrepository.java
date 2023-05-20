package com.example.demo;

import com.example.demo.shop.Customer;

import org.springframework.data.repository.CrudRepository;


//Customerrepository라는 repository를 정의해 Customer 객체의 데이터를 다룬다.
public interface Customerrepository extends CrudRepository<Customer, String>{

}