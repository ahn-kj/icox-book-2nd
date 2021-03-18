package com.akj.kotlinsample;

public class SingletonJava {

    // 생성자를 private 로 감춘다
    private SingletonJava(){}

    // 생성된 객체를 private 로 감추고 프로그램  시작할 때 초기화 한다.
    // 인스턴스 생성방법은 처음 사용할때 초기화하는 방법, 스레드 동기화 방법등 다양한 방법이 있다.
    // 자세한 것은 디자인패턴 관련 서적 참고.
    private static SingletonJava instance = new SingletonJava();

    // 외부에서 생성된 instance 에서 접근 할수 있는 방법을 제공
    public static SingletonJava getInstance(){
        return instance;
    }

    public void log(String text){
        System.out.println(text);
    }
}
