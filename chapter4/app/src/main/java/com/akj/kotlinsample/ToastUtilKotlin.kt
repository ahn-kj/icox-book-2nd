@file:JvmName("ToastUtil")

package com.akj.kotlinsample

import android.widget.Toast

fun toastShort(message: String) {
    Toast.makeText(MainApplication.getAppContext(), message, Toast.LENGTH_SHORT).show()
}

fun toastLong(message: String) {
    Toast.makeText(MainApplication.getAppContext(), message, Toast.LENGTH_LONG).show()
}

// 코틀린에서는 함수의 기본값을 지정 가능하다.
fun toast(message: String, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(MainApplication.getAppContext(), message, length).show()
}

@JvmOverloads
fun function(param1: Int, param2: Int = 2, param3: Int = 3, param4: Int = 4, param5: Int = 5) {

}

fun register(name:String, age:Int, tall:Int, weight:Int, address:String, point:Int, gender:Int){

}