package com.example.demo;

import com.example.demo.shop.CartItem;

import org.springframework.data.repository.CrudRepository;


//Cariitemrepository라는 repository를 정의해 cartitem객체의 데이터를 다룬다.
public interface CartItemrepository extends CrudRepository<CartItem, Long>{

}
