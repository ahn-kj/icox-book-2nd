package com.akj.kotlinsample

// 이름을 생성자로 받는것을 표현
class Person(val name: String) {
    // 나이
    var age: Int = 0

    // 닉네임 - 소문자만 허용
    var nickname: String = ""
        set(value) {
            // field 는 Setter 의 대상이 되는 field 를 의미
            field = value.toLowerCase()
        }
}