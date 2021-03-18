package com.akj.kotlinsample

import java.io.InputStreamReader
import java.net.URL
import kotlin.properties.Delegates

class User {
    // 닉네임은 DelegateString 클래스에 위임O
    var nickname by DelegateString()

    // lazy 위임은 val 키워드로 선언되어야만 가능함.
    // 네트워크에서 받은 텍스트는 시간이 걸리므로 실제로 사용할때 초기화
    val httpText by lazy {
        println("lazy init start")
        InputStreamReader(URL("https://www.naver.com").openConnection().getInputStream()).readText()
    }

    // name 프로퍼티 값이 변경될때 마다 자동으로 observable 의 코드가 실행된다.
    var name:String by Delegates.observable(""){
        property, oldValue, newValue ->
        println("기존값: ${oldValue}, 새로적용될값: ${newValue}")
    }
}

