package com.akj.kotlinsample

// open 키워드는 상속을 허용한다는 의미이다.
open class FooOpenClass {
    var property1 = 0

    // 메소드는 기본적으로 final 이고 오버라이드 불가하다.
    fun disable() {}

    // open 키워드로 메소드 역시 상속가능하게 변경할 수 있다.
    open fun animate(){}

    // 오버라이드 된 메소드는 하위 클래스에도 열려있다.
    override fun toString(): String {
        return super.toString()
    }
}
