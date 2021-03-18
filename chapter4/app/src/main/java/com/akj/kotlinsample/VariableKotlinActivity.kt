package com.akj.kotlinsample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.layout_variable.*
import java.text.SimpleDateFormat
import java.util.*

class VariableKotlinActivity : AppCompatActivity() {

    // 클릭된 횟수를 저장할 변수
    var clickCount = 0

    // Activity 가 시작된 시간
    val startTime = System.currentTimeMillis()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // UI 로 사용할 레이아웃 XML 파일을 지정한다.
        setContentView(R.layout.layout_variable)

        // 시작시간을 텍스트 형태로 변환
        val timeText = SimpleDateFormat("HH:mm:ss", Locale.KOREA).format(startTime)

        // 시작시간을 텍스트뷰에 보여줌
        startTimeLabel.text = "Activity 시작시간: ${timeText}"
        // 클릭된 횟수 보여줌
        clickCountLabel.text = "버튼이 클릭된 횟수:${clickCount}"

        // 버튼에 이벤트 리스너 설정
        button.setOnClickListener {
            // 클릭된 횟수 추가
            clickCount = clickCount + 1

            // UI 에 클릭횟수 다시 보여줌
            clickCountLabel.text = "버튼이 클릭된 횟수:${clickCount}"
        }
    }
}
