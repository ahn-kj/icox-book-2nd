package com.akj.kotlinsample

import org.junit.Assert
import org.junit.Test

class KotlinTest {
    @Test
    fun test1() {
        Assert.assertEquals(4, 2 + 2)
    }

    @Test
    fun testGetterSetter() {

        // 코틀린의 Person 객체를 생성하고 이름을 "John" 으로 설정
        val person = Person("john")

        // 코틀린은 age 를 직접 사용해도 자동으로 setter 가 불린다.
        person.age = 20

        // 설정한 값이 정상적인지 테스트
        // 마찬가지로 직접 프로퍼티 접근해도 자동으로 getter 가 불린다.
        Assert.assertEquals(20, person.age)
        Assert.assertEquals("john", person.name)
    }

    @Test
    fun testSetNickname() {
        val person = Person("john")
        // 대문자가 포함된 문자열을 닉네임으로 설정해도 소문자로 저장한다.
        person.nickname = "Banana"
        // 대문자가 포함된 문자열이 소문자로 되었는지 확인
        Assert.assertEquals("banana", person.nickname)
    }

    @Test
    fun testUser() {
        val user = User()
        // 닉네임을 대소문자가 섞인 문자열로 설정
        user.nickname = "death Note"
        // 닉네임은 모두 대문자로 변경되어야 한다. 예상대로 변경되었는지 확인
        Assert.assertEquals("DEATH NOTE", user.nickname)

        println(user.httpText)
    }

    @Test
    fun testUserLazy() {
        val user = User()
        // 초기화 순서를 확인하기 위해 프린트를 추가
        println("not init")
        // 불리는 시점에는 초기화가 되어 NULL 이 아니게 된다.
        Assert.assertNotNull(user.httpText)
    }

    @Test
    fun testUserNameObservable() {
        val user = User()
        user.name = "john"
        user.name = "james"
    }

    @Test
    fun testAnimalByMap() {
        // Animal 객체를 생성할때 맵 객체를 넘긴다.
        val animal = Animal(mutableMapOf(
            "name" to "cat",
            "age" to 20)
        )

        // name 속성이 map 객체에 정상적으로 위임되었는지 확인
        Assert.assertEquals("cat", animal.name)
        // age 속성이 map 객체에 정상적으로 위임되었는지 확인
        Assert.assertEquals(20, animal.age)

        // 프로퍼티의 값을 변경한다.
        animal.age = 21
        animal.name = "dog"

        // map 의 값들이 바꼈는지 확인
        Assert.assertEquals("dog", animal.map["name"])
        Assert.assertEquals(21, animal.map["age"])
    }

    @Test
    fun testFruit() {
        // 객체의 속성 값을 같도록 Fruit 객체 2개 생성
        val fruit1 = Fruit("바나나", "바나나 길어")
        val fruit2 = Fruit("바나나", "바나나 길어")

        // 각각 프린트한다. toString() 메소드가 호출된다.
        println(fruit1)
        println(fruit2)

        // 두 객체가 같은지 비교한다. equals() 호출됨.
        Assert.assertEquals(fruit1, fruit2)

        // 두 객체의 해시코드가 같은지 비교한다.
        Assert.assertEquals(fruit1.hashCode(), fruit2.hashCode())
    }

    @Test
    fun testLambda1() {
        // 함수의 파라미터로 람다식 전달
        println(sum(1, 2))
        // 람다식 반환 값으로 비교
        Assert.assertEquals(4, sum(1, 3))

        // 함수에 람다 표현식을 바로 전달
        Assert.assertEquals(4, { x: Int, y: Int -> x * y }(2, 2))

        // 람다표현식 내부에서 람다표현식을 반환
        val exp = { x: Int, y: Int ->
            { z: Int -> (x + y) * z }
        }
        // exp2 --> {z: Int -> {(3 +2) * z}}
        val exp2 = exp(3, 2)
        // result --> (3 + 2) * 4
        val result = exp2(4)
        // 결과 확인
        Assert.assertEquals(20, result)
    }

    @Test
    fun testCollectionApi() {
        // 컬렉션을 만든다
        val list = listOf(1, "2", 3, 4, 5.7, 1, 2)

        // filter: 컬렉션에서 특정 조건이 맞는 항목만 추출하여 새로운 컬렉션을 만든다 --> Int 타입만 추출한다.
        println(list.filter { item -> item is Int })

        // 람다 표현식에서 파라미터가 하나인 경우 생략이 가능하다.
        // 파라미터는 it 키워드로 접근 가능
        println(list.filter { it is Int })

        // map: 컬렉션에서 아이템을 변환하여 새로운 컬렉션을 만든다.
        println(list.map { "value: ${it}" })

        // filter 에서 반환된 컬렉션을 map 으로 변환
        println(list.filter { it is Int }.map { "value: ${it}" })

        // 아이템을 찾는다.
        println(list.find { it is Double })

        // gorup 으로 변환한다.
        val map = list.groupBy { it.javaClass }
        println(map)

        // 컬렉션 안에 컬렉션이 있는 새로운 리스트를 만든다.
        val list2 = listOf(listOf(1, 2), listOf(3, 4))
        println(list2)

        // map 으로 항목을 변환한다.
        println(list2.map { "value: ${it}" })

        // flatmap 으로 리스트를 평평하게 만들고 변환한다.
        println(list2.flatMap { it.toList() })
    }

    @Test
    fun testExtensions(){
        val str = "Hello, Extensions"
        // lastString() 함수를 원래 String 클래스의 메소드처럼 사용  가능
        Assert.assertEquals("s", str.lastString())
    }
}