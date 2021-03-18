package com.akj.kotlinsample;

import org.junit.Assert;
import org.junit.Test;

public class JavaTest {
    @Test
    public void test1() {
        Assert.assertEquals(4, 2 + 2);
    }


    @Test
    public void testGetterSetter() {

        // PersonJava 클래스의 객체를 생성하고 이름을 "John" 나이를 20으로 설정
        PersonJava personJava = new PersonJava("john");
        personJava.setAge(20);

        // 설정한 값이 정상적인지 테스트
        Assert.assertEquals(20, personJava.getAge());
        Assert.assertEquals("john", personJava.getName());

        // 코틀린의 Person 객체를 생성하고 이름을 "John" 나이를 20으로 설정
        Person person = new Person("john");
        person.setAge(20);

        // 설정한 값이 정상적인지 테스트
        Assert.assertEquals(20, person.getAge());
        Assert.assertEquals("john", person.getName());
    }


    @Test
    public void testSetNickname() {
        // 자바로 작성한 PersonJava 클래스의 객체 생성
        PersonJava personJava = new PersonJava("john");

        // 대문자가 포함된 문자열을 닉네임으로 설정해도 소문자로 저장한다.
        personJava.setNickname("Apple");

        // 대문자가 포함된 문자열이 소문자로 되었는지 확인
        Assert.assertEquals("apple", personJava.getNickname());

        // 코틀린으로 작성한 Person 클래스 생성
        Person person = new Person("john");

        // 대문자가 포함된 문자열을 닉네임으로 설정해도 소문자로 저장한다.
        person.setNickname("Apple");

        // 대문자가 포함된 문자열이 소문자로 되었는지 확인
        Assert.assertEquals("apple", person.getNickname());
    }

    @Test
    public void testMoveObject() {
        MoveObject moveObject = new MoveObject();
        // MoveObject 의 speed 를 아직 설정하지 않았으므로 0 인 상태로 calcAccuracy 함수를 호출
        int accuracy = Calculator.calcAccuracy(moveObject, 3);

        // Calculator.calcAccuracy() 는 MoveObject 의 스피드가 0 인 경우 자동으로 스피드를 1로 만들고 계산함
        Assert.assertEquals(1, moveObject.getSpeed());

        // MoveObject 의 실제 구현체를 CantMoveObject 로 생성
        MoveObject cantMoveObject = new CantMoveObject();
        // 똑같이 speed 를 설정하지 않고 calcAccuracy 를 호출
        accuracy = Calculator.calcAccuracy(cantMoveObject, 3);
        // 위 코드에서 이미 에러가 발생해 실행되지 않음
        Assert.assertEquals(1, cantMoveObject.getSpeed());
    }

    @Test
    public void testSingletonJava() {
        // 생성자를 private 로 감췄기 때문에 new 로 생성 불가
        // SingletonJava singletonJava = new SingletonJava();

        // 외부에 공개된 getInstance() 메소드로 객체에 접근
        SingletonJava singletonJava = SingletonJava.getInstance();

        // 객체의 메소드 사용가능
        singletonJava.log("hi, singleton");
        Object obj;
    }

    @Test
    public void testFruit() {
        FruitJava fruitJava = new FruitJava();
        fruitJava.fruitName = "사과";
        fruitJava.description = "사과는 맛있다.";
        // 객체를 넘기면 자동으로 toString() 메소드 추가
        System.out.println(fruitJava);
    }

    @Test
    public void testFruitEquals() {
        // FruitJava 객체 2개를 생성한다.
        FruitJava fruitJava1 = new FruitJava();
        FruitJava fruitJava2 = new FruitJava();

        // 모든 속성을 같게 한다.
        fruitJava1.fruitName = "바나나";
        fruitJava2.fruitName = "바나나";

        fruitJava1.description = "바나나는 길다";
        fruitJava2.description = "바나나는 길다";

        // 두 객체가 같은지 확인
        Assert.assertEquals(fruitJava1, fruitJava2);
    }

    @Test
    public void testFruitHashCode() {
        // FruitJava 객체 2개를 생성한다.
        FruitJava fruitJava1 = new FruitJava();
        FruitJava fruitJava2 = new FruitJava();

        // 모든 속성을 같게 한다.
        fruitJava1.fruitName = "바나나";
        fruitJava2.fruitName = "바나나";

        fruitJava1.description = "바나나는 길다";
        fruitJava2.description = "바나나는 길다";

        Assert.assertEquals(fruitJava1.hashCode(), fruitJava2.hashCode());
    }

    @Test
    public void testExtFunc() {
        // 자바에서 확장함수는 최상위 함수 호출과 같음
        String lastString = StringExtKt.lastString("apple");
        Assert.assertEquals("e", lastString);
    }

    @Test
    public void testNPE1() {
        NPE npe = new NPE();
        // 3글자에 단어를 함수에 전달해 결과 테스트
        Assert.assertEquals(3, npe.strLen("abc"));

        // Null 을 전달할때 테스트
        Assert.assertEquals(0, npe.strLen(null));
    }

    @Test
    public void testNullType() {
        Assert.assertEquals(true, null instanceof String);
    }
}
