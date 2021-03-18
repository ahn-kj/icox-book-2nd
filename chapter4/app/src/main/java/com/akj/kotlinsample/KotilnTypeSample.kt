package com.akj.kotlinsample

//var clickCount = 0
var clickCount: Int = 0

fun sample1() {

    var name = "akj"
    // name 은 String 타입이므로 정수 타입인 Int 를 할당할 수 없음
    // name = 30
}


// Any 클래스는 자바의 Object 처럼 코틀린의 최상위 클래스
fun plus3(param: Any) {
    // param 은 타입체크를 했기 때문에 Int 로 스마트 캐스팅됨
    if (param is Int) {
        var result = 3 + param
        println("" + result)
    } else {
        println("0")
    }
}