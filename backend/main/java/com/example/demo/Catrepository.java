package com.example.demo;

import com.example.demo.domain.Cat;

import org.springframework.data.repository.CrudRepository;

//Catrepository라는 repository를 정의해 cat객체의 데이터를 다룬다.
public interface Catrepository extends CrudRepository<Cat, Long>{
}
