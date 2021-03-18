package com.akj.kotlinsample;

public class PropertyJava {
    // Field 가 선언되어 있고 Getter, Setter 가 있는 경우 Property
    private int property1 = 0;

    public int getProperty1() {
        return property1;
    }

    public void setProperty1(int property1) {
        this.property1 = property1;
    }

    // 변수의 값을 읽을수만 있는 경우도 Property 라 할수 있음
    private String property2 = "";

    public String getProperty2() {
        return property2;
    }

    // 단순 field 는 property 아니다.
    private int notProperty1 = 0;

    // 클래스 변수 역시 property 가 아님
    private static int notProperty2;
}
