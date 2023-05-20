package com.example.demo;

import com.example.demo.domain.Dog;

import org.springframework.data.repository.CrudRepository;


//Dogrepository라는 repository를 정의해 dog객체의 데이터를 다룬다.
public interface Dogrepository extends CrudRepository<Dog, Long>{

}
