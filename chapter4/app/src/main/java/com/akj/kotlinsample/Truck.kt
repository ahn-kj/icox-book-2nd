package com.akj.kotlinsample

class Truck(val id: Int, val name: String) {

    // equals 를 오버라이드 함, id 가 같으면 같은 객체로 취급
    override fun equals(other: Any?): Boolean {
        // as? 연산자를 사용하면 타입이 같은경우 캐스팅이 정상적으로 되고
        // 캐스팅이 실패하면 null 이 반환된다.
        // null 이 반환된 경우 엘비스 연산자의 디펄트 식이 실행되어 false 가 리턴된다.
        val otherTruck = other as? Truck ?: return false

        // otherTruck 은 스마트캐스팅 되어 널 을 신경쓸 필요가 없다.
        return otherTruck.id == id
    }
}