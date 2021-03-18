package com.akj.kotlinsample

// 코틀린 타입은 기본적으로는 널(NULL) 을 허용하지 않는다.
fun strLenNonNull(str: String): Int {
    // 파라미터로 받은 str 은 널이 될수 없으므로 안전하다.
    return str.length
}

// 만일 널(NULL) 가능성이 있다면 타입에 ?를 붙여야 한다.
fun strLenNullable(str: String?): Int {
    // 널 가능성이 있는 str 메소드에 접근하면 에러가 발생한다.
    // return str.length

    // if 로 널체크를 한다.
    if (str != null) {
        // 널체크 이후 str 은 String? 타입에서 String 타입으로 스마트 캐스팅된다.
        return str.length
    } else {
        return 0
    }
}

// 문자열에 끝 Char 를 반환한다.
fun strLastCharNullable(str: String?): Char {
    // ?. 연산자를 사용하여 str 이 널이면 "".single() 이 반환 된다.
    return str?.get(str.length - 1) ?: "".single()
}

// let 함수를 이용한 에제
fun strPrintLen(str: String?) {
    // let 함수는 수신객체인 str 이 널이면 실행되지 않는다.
    str?.let { print(strLenNonNull(it)) }
}