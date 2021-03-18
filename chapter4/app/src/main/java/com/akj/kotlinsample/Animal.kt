package com.akj.kotlinsample

// Animal 클래스는 map 객체를 생성자에서 받는다.
class Animal(val map:MutableMap<String, Any?>) {
    // 프로퍼티를 map 객체로 위임한다. map 객체에서 값을 읽고,
    // 값을 변경하면 map 객체에서 값이 변경된다.
    var name:String by map
    var age:Int by map

}