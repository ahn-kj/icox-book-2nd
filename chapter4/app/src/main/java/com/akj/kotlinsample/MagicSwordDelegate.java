package com.akj.kotlinsample;

// ISword 인터페이스를 상속받는다
public class MagicSwordDelegate implements ISword {
    // ISword 타입의 객체를 필드로 가지고 있는다.
    // 단지 Sword 클래스를 확장하려면 Sword 타입으로 해도 되지만 ISword 타입으로 하면 확장성이 더욱 커지게 된다.
    ISword iSword;

    // 생성자에서 ISword 타입의 객체를 생성자에서 받는다
    public MagicSwordDelegate(ISword iSword) {
        this.iSword = iSword;
    }

    // 장착시 불리는 메소드
    @Override
    public void equip() {
        // 멋진 사운드를 플레이한다.
        playWonderfulSound();

        // 기존 기능은 iSword 에 위임한다.
        iSword.equip();
    }

    // 확장기능 - 멋진 사운드를 플레이하는 메소드
    public void playWonderfulSound() {
        // 멋진 사운드를 플레이 한다.
        System.out.println("짜잔");
    }
}
