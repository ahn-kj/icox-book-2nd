package com.akj.kotlinsample

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.layout_control.*

class ControlKotlinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_control)

        // 버튼이 클릭되었을때의 이벤트리스너 를 설정한다.
        button.setOnClickListener {
            // numberField 의 값을 읽어 int 형으로 변환한다.
            val number = numberField.text.toString().toInt()

            toast("${number} 는 2의 배수입니다.")
            toast("${number} 는 2의 배수입니다.", Toast.LENGTH_LONG)

            toast(message = "${number} 는 2의 배수입니다.", length = Toast.LENGTH_LONG)

            function(param1 = 10, param3 = 20)

            // when 문은 케이스로 조건식도 사용 가능
            when {
                number % 2 == 0 -> toastShort("${number} 는 2의 배수입니다.")
                number % 3 == 0 -> toastShort("${number} 는 3의 배수입니다.")
                else -> toastShort("${number}")
            }

            // 코틀린에서는 switch 문을 대체해 when 을 사용할 수 있다.
            when (number) {
                // number 가 1 ~ 4 까지인 경우 실행된다.
                in 1..4 -> button.text = "실행 - 4"
                // number 가 9, 18 인 경우 실행된다.
                9, 18 -> {
                    button.text = "실행 - 9"
                }
                else -> button.text = "실행"
            }
        }
    }
}

