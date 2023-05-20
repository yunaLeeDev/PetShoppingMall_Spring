package com.example.demo;


import com.example.demo.domain.Groomable;
import com.example.demo.domain.Pet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@EnableAspectJAutoProxy
public class DemoApplication {
	static String[] names = {"젤리", "콩이", "사랑이", "자몽이", "꼬맹이", "모리", "하리", "콩", "하트", "태양"};
	public static void main(String[] args) {
		//Spring boot를 돌린다.
		SpringApplication.run(DemoApplication.class, args);
	}
	
	//petrepository 객체를 선언해준다.
	@Autowired
	Petrepository petrepository;

	//pets/{petId}/feed에서는 이 메소드를 통해 화면을 표출한다.
	@RequestMapping(method=RequestMethod.PUT, path="pets/{petId}/feed")
	public String feedPet(@PathVariable(value = "petId") Long petId)  throws Exception{
		//petrepository에서 petid와 일치하는 class를 찾아 thepet객체에 담아준다.
		Pet thePet = petrepository.findById(petId).get();
		//eat메소드를 사용한다.
		thePet.eat();
		//petrepository에서 thepet을 저장해준다.
		petrepository.save(thePet);
		return "잘 먹였습니다!" ;
	}

	//pets/{petId}/sleep에서는 이 메소드를 통해 화면을 표출한다.
	@RequestMapping(method=RequestMethod.PUT, path="pets/{petId}/sleep")
	public String sleep(@PathVariable(value = "petId") Long petId) throws Exception{
		//petrepository에서 petid와 일치하는 class를 찾아 thepet객체에 담아준다.
		Pet thePet = petrepository.findById(petId).get();
		//sleep메소드를 사용한다.
		thePet.sleep();
		return "잘 재웠습니다!";
	}
	//pets/{petId}/groom에서는 이 메소드를 통해 화면을 표출한다.
	@RequestMapping(method=RequestMethod.PUT, path="pets/{petId}/groom")
	public String groomPet(@PathVariable(value = "petId") Long petId) throws Exception{
		//petrepository에서 petid와 일치하는 class를 찾아 thepet객체에 담아준다.
		 Pet thePet = petrepository.findById(petId).get();
		 //thepet이 groomable을 상속하는 경우에만 if문 돌린다.
			if(thePet instanceof Groomable){
				//grooming해서 받아온 message를 저장해온다.
				String message = ((Groomable) thePet).grooming();
				petrepository.save(thePet);
				return message;
			}
			//아닌 경우에는 그루밍이 불가능한 Pet이라고 출력한다.
			return "그루밍이 불가능한 Pet입니다.";
	}

	//cats/{petId}/groom 링크로 왔을 때는 이 메소드를 실행한다.
	@RequestMapping(method=RequestMethod.PUT, path="cats/{petId}/groom")
	public String groomCat(@PathVariable(value = "petId") Long petId) throws Exception{		
		//groompet으로 보내 메소드를 실행하고 반환되는 값을 받아온다.	
		return groomPet(petId);
	}


	//아래의 두 메소드는 코드를 줄이기 위해, cats, dogs 링크로부터 온 동작들을 feedpet으로 보내 수행하는 것이다.

	//cats/{petId}/feed 링크로 왔을 때는 이 메소드를 실행한다.
	@RequestMapping(method=RequestMethod.PUT, path="cats/{petId}/feed")
	public String feedCat(@PathVariable(value = "petId") Long petId) throws Exception{	
		//feedpet으로 보내 메소드를 실행하고 반환되는 값을 받아온다.	
			return feedPet(petId);
	}
	
	//dogs/{petId}/feed 링크로 왔을 때는 이 메소드를 실행한다.
	@RequestMapping(method=RequestMethod.PUT, path="dogs/{petId}/feed")
	public String feedDog(@PathVariable(value = "petId") Long petId) throws Exception{
			
		//feedpet으로 보내 메소드를 실행하고 반환되는 값을 받아온다.
			return feedPet(petId);
	}

}
