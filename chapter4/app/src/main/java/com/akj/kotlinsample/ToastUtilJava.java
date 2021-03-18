package com.akj.kotlinsample;

import android.widget.Toast;

public class ToastUtilJava {
    // 짧은 토스트 메세지를 보여주는 함수
    public static void toastShort(String message) {
        Toast.makeText(MainApplication.getAppContext(), message, Toast.LENGTH_SHORT).show();
    }

    // 긴 토스트 메세지를 보여주는 함수
    public static void toastLong(String message) {
        Toast.makeText(MainApplication.getAppContext(), message, Toast.LENGTH_LONG).show();
    }

    // 파라미터에 따라 긴 토스트 메세지, 또는 짧은 토스트 메세지를 보여준다.
    public static void toast(String message, int length){
        Toast.makeText(MainApplication.getAppContext(), message, length).show();
    }

    // 파라미터의 기본값을 사용하기 위해 메소드 오버라이딩
    public static void toast(String message){
        toast(message, Toast.LENGTH_SHORT);
    }

    // 파라미터가 5개인 함수, 이중 param2 ~ param5 가 거의 같은 값을 사용한다면?
    public static void function(int param1, int param2, int param3, int param4, int param5){

    }

    // param5 의 기본값을 지정한 함수
    public static void function(int param1, int param2, int param3, int param4){
        function(param1, param2, param3, param4, 5);
    }

    // param4 ~ param5 의 기본값을 지정한 함수
    public static void function(int param1, int param2, int param3){
        function(param1, param2, param3, 4, 5);
    }

    // param3 ~ param5 의 기본값을 지정한 함수
    public static void function(int param1, int param2){
        function(param1, param2, 3, 4, 5);
    }

    // param2 ~ param5 의 기본값을 지정한 함수
    public static void function(int param1){
        function(param1, 2, 3, 4, 5);
    }

}
