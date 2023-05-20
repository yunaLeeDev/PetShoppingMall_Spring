package com.example.demo.domain;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


//부모가 구분하는데 사용하는 칼럼을 dog라고 넣어준다.
@Entity
@DiscriminatorValue("dog")
public class Dog extends Pet implements Runnable{
    
    
    //부모 class인 Pet class로부터 overide받아와서 dog만의 메소드로 특화시킨다.
    @Override
    public void speak() {
        if (getEnergy() <5) {
            
            //에너지가 5이하일때는 "I'm Hungry" 출력
            System.out.println("I'm Hungry");
        } else {
            //아닐 때는 "월월" 출력
            System.out.println("월월");  
        }             
    }
    
    //부모 class인 Pet class로부터 overide해와서 dog만의 메소드로 특화시킨다.
    @Override
    public void run() {
        //"Dog run"을 출력한다.
        System.out.println("Dog run");
    }

     //부모 class인 Pet class로부터 overide해와서 dog만의 메소드로 특화시킨다.
    @Override
    public void eat() {
        //Energy를 1증가 시킨다.
        setEnergy(getEnergy()+1);

    }
    //부모 class인 Pet class로부터 overide해온다.
    @Override
    public void sleep() {
        //부모 class의 sleep 메소드의 기존 동작을 불러오고 거기에 덧붙인다.
        super.sleep();
        //Appearance를 1증가시킨다.
        setAppearance(getAppearance()+1);
    }

    
}
