package com.akj.kotlinsample;

// 검 객체 클래스
public final class Sword implements ISword {
    // 검의 이름
    String name;

    // 생성자에서 이름을 받는다
    public Sword(String name) {
        this.name = name;
    }

    // 장착시 불리는 메소드
    public void equip(){
        System.out.println(name + " 이 장착되었습니다.");
    }
}
