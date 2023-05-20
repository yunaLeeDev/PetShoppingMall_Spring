package com.example.demo;

import com.example.demo.domain.Pet;

import org.springframework.data.repository.CrudRepository;


//Petrepository라는 repository를 정의해 pet객체의 데이터를 다룬다.
public interface Petrepository extends CrudRepository<Pet, Long>{

}
