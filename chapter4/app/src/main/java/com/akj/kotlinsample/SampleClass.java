package com.akj.kotlinsample;

public class SampleClass {
    int outerField1 = 0;

    // 클래스 내부에 선언된 클래스를 내부 클래스(Inner Class) 라고 한다.
    // 내부 클래스는 외부로 선언된 SampleClass 객체가 생성되어야 존재할 수 있다.
    class InnerClass {
        // 내부 클래스에서는 외부 클래스의 필드에 접근 가능하다.
        int myField = outerField1;
    }

    // 클래스 내부에 선언되어 있지만 static 이 붙으면 중첩 클래스가 된다.
    // 중첩 클래스는 외부에 있는 SampleClass 객체가 없어도 존재할 수 있다.
    public static class NestedClass {
        // 중첩 클래스는 외부 클래스 필드에 접근이 불가하다.
        // int myField = outerField1;
    }
}
