package com.akj.kotlinsample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.layout_view_binding.*

class BmiKotlinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // UI 로 사용할 레이아웃 XML 파일을 지정한다.
        setContentView(R.layout.layout_view_binding)
        // bmi 버튼이 클릭된 경우 동작하는 코드를 작성한다.
        bmiButton.setOnClickListener {
            // tallField 의 값을 읽어온다.
            val tall = tallField.text.toString().toDouble()

            // weightField 의 값을 읽어온다.
            val weight = weightField.text.toString().toDouble()

            // BMI 를 계산한다. 체중(kg) / 키(m) * 키(m) >> 키를 cm 로 입력받았으므로 100 으로 나누어 제곱한다.
            // Math.pow() 는 넘겨받은 파라미터 값을 제곱해서 돌려준다.
            // 예를 들어 Math.pow(2, 3) 은 2의 3제곱 8을 돌려준다.
            val bmi = weight / Math.pow(tall / 100, 2.0)

            // 결과 BMI 를 resultLabel 에 보여준다.
            resultLabel.text = "키: ${tallField.text}, 체중: ${weightField.text}, BMI: $bmi"
        }
    }
}
