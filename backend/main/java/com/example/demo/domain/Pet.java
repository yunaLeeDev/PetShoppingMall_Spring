package com.example.demo.domain;


import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@DiscriminatorColumn(
    //부모 class에 선언하는 자식 class 구분 용도의 컬럼이다.
    //자식 class에서 이를 선언해준다.
    discriminatorType = DiscriminatorType.STRING,
    name = "pet_type",
    columnDefinition = "CHAR(5)"
)

public abstract class Pet {

    //id라는 속성을 선언하고 Long type으로 지정해준다.
    @Id @GeneratedValue
    Long id;
    
    //id의 getter setter를 만들어준다.
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    //type 속성을 만들어주고, String type으로 지정해준다.
    String type;

    //type의 getter setter를 만들어준다.
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    //name 속성을 만들어주고, String type으로 지정해준다.
    String name;

    //type의 getter setter를 만들어준다.
    public String getName() {
        return name;
    }
    public void setName(String name) {
        //이름은 꼭 들어가야 하기에, 없으면 에러를 배출한다.
        if(name==null) throw new IllegalArgumentException("이름은 꼭 들어가야 합니다.");
        this.name = name;
    }

    //추상화 메소드 speak은 상속받은 객체에서 만들어 사용해야 한다.
    abstract public void speak();

    //integer 형의 energy 속성을 정의해준다.
    //외부의 간섭을 배제하려 private을 통해 보호해준다.
    private int energy = 0;
    //getter setter를 만들어준다.
    public int getEnergy(){
            return energy;
        }
        protected void setEnergy(int energy){
            //계산했을때 3보다 변화가 작으면 energy를 set해준다.
            if (Math.abs(this.energy - energy)<3) {
                this.energy = energy;
            } else {
                //3보다 에너지 변화가 크면 에러를 배출한다.
                throw new IllegalArgumentException("Energy change is too big");  }}

                //appearance 속성을 만들어준다.
                private int appearance;
                
                //getter setter를 만들어준다.
                public int getAppearance() {

                    return appearance;

                }
                protected void setAppearance(int appearance) {

                    this.appearance = appearance;

                }            


        //eat메소드로, 에너지를 2증가 시켜준다.       
        public void eat(){
            energy +=2;         
                }
                
      //toString 메소드로, 하이퍼링크를 걸어준다.          
      @Override
      public String toString(){
          //class의 이름을 추출하고, 소문자로 만들어 생성한 하이퍼링크를 class이름을 추출해 걸어준다.
        return "<a href='./"+this.getClass().getSimpleName().toLowerCase()+"'"+">"+this.getClass().getSimpleName() + "</a>";
      }
      //sleep 메소드로 에너지를 2증가시키고 "성공적으로 재웠습니다."를 출력한다.
    public void sleep() {
        energy+=2;
        System.out.println("성공적으로 재웠습니다");
    }
}
