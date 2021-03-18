package com.akj.kotlinsample;

public class Calculator {
    // 명중률 계산 함수, 파라미터로 MoveObject 객체와, 공격자의 명중률을 받는다.
    public static int calcAccuracy(MoveObject moveObject, int attackerAccuracy){

        // moveObject 의 speed 가 0 인 경우 잘못된 상황으로 판단하여 스피드 1 을 추가
        if(moveObject.getSpeed() == 0){
            moveObject.addSpeed(1);
        }

        // 위의 코드로 moveObject.getSpeed() 가 0 이 나오지 않는다고 생각하고 나눗셈을 함.
        double resultAccuracy = attackerAccuracy / moveObject.getSpeed();
        return (int) resultAccuracy;
    }
}
