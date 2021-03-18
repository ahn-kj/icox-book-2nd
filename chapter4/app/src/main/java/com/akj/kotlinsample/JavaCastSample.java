package com.akj.kotlinsample;

public class JavaCastSample {
    public static void plus3(Object param) {
        if (param instanceof Integer) {
            // 자바의 경우 if 문으로 타입체크를 했지만 변수를 다시 캐스팅해야한다
            // 이때 타입 캐스팅을 잘못하는 경우 에러가 발생한다.
            double result = 3 + (double) param;
            System.out.println("" + result);
        } else {
            System.out.println("0");
        }
    }
}
