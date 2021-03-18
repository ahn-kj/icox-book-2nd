package com.akj.kotlinsample

class Sample {
    val field1 = 0


    // 코틀린은 내부에 클래스를 선언하면 중첩클래스가 됨
    class NestedClass {
        // 중첩 클래스에서는 외부 클래스 속성에 접근 불가
        // val myField = field1
    }

    // 코틀린에서 내부 클래스를 선언하려면 inner 키워드 사용
    inner class InnerClass {
        // 내부 클래스에서는 외부 클래스의 속성에 접근 가능
        val myField = field1
    }
}