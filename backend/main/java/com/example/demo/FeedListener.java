package com.example.demo;

//listener를 다중상속받아온다.
public class FeedListener implements Listener{

    //feedCriteria라는 속성 선언한다.
    int feedCriteria = 0;
    //constructer를 통해 만들어질때부터 기준 사료량을 정해놓는다.
    public FeedListener(int criteria){
        this.feedCriteria = criteria;
    }

    //메소드를 overide해와 energy가 바뀔때, energy가 기준사료량보다 작을때
    //"please feed some food"라고 출력하게 만들어준다.
    @Override
    public void energyChanged(int energy) {
        if(energy < feedCriteria){
            System.out.println("please feed some food");
        }
    }
}
    
