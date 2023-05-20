package com.example.demo;

import com.example.demo.domain.Cat;
import com.example.demo.domain.Pet;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;


//RepresentationModel을 사용하기 위한 RepresentationModelProcessor를 상속해온다.
@Component
public class RepositorySearchesProcessor implements RepresentationModelProcessor<EntityModel<Pet>> {

    //<pet>형태의 model에 대하여 해당 링크를 추가하는 작업을 실행한다. 
    @Override
    public EntityModel<Pet> process(EntityModel<Pet> model) {
        model.add(Link.of(model.getRequiredLink("self").getHref() + "/feed").withRel("feed"));
        //cat class를 활용한 객체에서는 groom링크까지 추가한다.
        if(model.getContent() instanceof Cat)
            model.add(Link.of(model.getRequiredLink("self").getHref() + "/groom").withRel("groom"));
        //model을 return해준다.
        return model;
    }
}
