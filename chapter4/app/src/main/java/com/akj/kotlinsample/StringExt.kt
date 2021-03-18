package com.akj.kotlinsample

// String 클래스에 lastString 확장함수를 추가로 정의한다.

fun String.lastString():String {
    return this.get(this.length - 1).toString()
}

class ExtTest {
    // String 클래스에 extFunc 라는 확장함수를 추가한다.
    fun String.extFunc(){
        // 확장함수 String.lastString() 에 접근 가능하다.
        println(this.lastString())
    }

    fun method1(){
        // 확장함수 String.extFunc() 에 접근 가능하다.
        "test".extFunc()
    }
}

fun test(){
    // 확장함수 String.lastString() 에 접근 가능
    "test".lastString()

    // 확장함수 String.extFunc() 에는 접근 불가
//    "test".extFunc()
}
