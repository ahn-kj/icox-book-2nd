package com.akj.kotlinsample

class PropertySample {
    var name: String
        // Setter 에서는 print 함수를 호출한다.
        set(value: String) {
            print("set")
        }
        // 무조건 "Alice" 문자열을 반환한다.
        get():String {
            return "Alice"
        }
}