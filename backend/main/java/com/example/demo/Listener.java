package com.example.demo;

//interface class로, 추상화 메소드로만 이루어져있다.
public interface Listener {
    //이를 자식 class에서 만들어 사용함.
    void energyChanged(int energy);
}
