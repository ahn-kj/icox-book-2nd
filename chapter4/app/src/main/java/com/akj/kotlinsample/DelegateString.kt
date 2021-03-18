package com.akj.kotlinsample

import kotlin.reflect.KProperty

class DelegateString {
    // Setter 에서 호출된 값을 저장할 변수
    var text = ""

    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return text
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        // 대문자로 변경하여 저장
        text = value.toUpperCase()
        // Setter 에 호출될때의 문자열과 변경후 문자열을 프린트
        println("$value ==> ${text}")
    }
}