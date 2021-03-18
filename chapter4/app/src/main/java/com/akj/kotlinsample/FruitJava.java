package com.akj.kotlinsample;

import java.util.Objects;

public class FruitJava {
    // 과일 이름
    String fruitName;
    // 과일 설명
    String description;

    @Override
    public String toString() {
        return "FruitJava(" + fruitName + ", " + description + ")";
    }

    @Override
    public boolean equals(Object obj) {
        // 먼저 같은 클래스인지 확인 한다.
        if(obj instanceof FruitJava){
            // FruitJava 클래스로 캐스팅한다.
            FruitJava another = (FruitJava) obj;

            // 모든 속성이 같다면 같은 객체로 취급한다.
            return fruitName.equals(another.fruitName) && description.equals(another.description);
        }

        // 클래스가 같지 않다면 서로 다른 객체
        return false;
    }

    // equals() 가 오버라이드 된 경우 반드시 hashCode 도 오버라이드 해야한다.
    @Override
    public int hashCode() {

        // 객체가 같으면 해시코드도 같아야한다.
        // 즉 fruitName,  description 이 같으면 같은 해시코드를 반환해야 한다.
        int hash = 7;
        hash = 31 * hash + (fruitName == null ? 0 : fruitName.hashCode());
        hash = 31 * hash + (description == null ? 0 : description.hashCode());

        return hash;
    }
}
