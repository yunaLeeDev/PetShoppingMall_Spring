package com.example.demo;

import com.example.demo.shop.CartItem;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;


//RepresentationModel을 사용하기 위한 RepresentationModelProcessor를 상속해온다.
@Component
public class RepositorySearchersProcessor implements RepresentationModelProcessor<EntityModel<CartItem>>{
  
    //<cartitem>형태의 model에 대하여 해당 링크를 추가하는 작업을 실행한다. 
    @Override
    public EntityModel<CartItem> process(EntityModel<CartItem> model) {
        model.add(Link.of(model.getContent().getPet()).withRel("pet"));       
        //model을 return해준다.
        return model;
    }
}
