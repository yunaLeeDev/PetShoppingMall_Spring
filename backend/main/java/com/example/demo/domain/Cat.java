package com.example.demo.domain;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

//부모가 구분하는데 사용하는 칼럼을 cat이라고 넣어준다.
@Entity
@DiscriminatorValue("cat")
public class Cat extends Pet implements Groomable, Serializable, Runnable{


    //constructor에서 부모 class인 Pet class에 있는 setType 메소드를 이용해 cat class로 만드는 객체의 type을 전부 cat으로 지정해준다.
    public Cat() {
        this.setType("Cat");
    }
  
    //부모 class인 Pet class로부터 overide받아와서 cat만의 메소드로 특화시킨다.
    @Override
    public void speak() {       
        if (getEnergy() <5) {
            //에너지가 5이하일때는 "I'm Hungry" 출력
            System.out.println("I'm Hungry");
        } else {
            //아닐때는 "야옹" 출력
            System.out.println("야옹");
        }        
    }
    //부모 class인 Pet class로부터 overide해와서 cat만의 메소드로 특화시킨다.
    @Override
    public void run() {
        //run 메소드를 사용하면 "cat run" 출력
        System.out.println("cat run");   
    }

    //다중상속을 받는 Groomable class로부터 overide해와서 cat만의 메소드로 구현한다.
    @Override
    public String grooming(){
        //Appearance를 1 증가시킨다.
    setAppearance(getAppearance()+1);
        //"야옹. 행복하다 집사야~~"를 출력한다.
        return "야옹. 행복하다 집사야~~";
    }

    //부모 class인 Pet class로부터 overide해온다.
    @Override
    public void eat() {
        //pet class의 eat메소드를 super로 불러와 그대로 사용한다.
        super.eat();
    }

    //부모 class인 Pet class로부터 overide해온다.
    @Override
    public void sleep() {
        //pet class의 sleep메소드를 super로 불러와 그대로 사용한다.
        super.sleep();
    }
    
}
