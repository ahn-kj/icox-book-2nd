package com.akj.kotlinsample;

// 이동 가능한 객체
// 이 클래스는 상속 불가
public class MoveObject {
    // 이동 스피드
    protected int speed;

    public void addSpeed(int param) {
        this.speed = speed + param;
    }

    public int getSpeed() {
        return speed;
    }

    // 좌표
    public int x, y;
}
