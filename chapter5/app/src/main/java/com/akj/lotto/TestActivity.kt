package com.akj.lotto

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_test.*

class TestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        // 코드에서 View에 이벤트 리스너를 설정하는 방법
        // Kotlin 에서는 Android Extension 덕분에 findViewById 없이 바로 접근 가능하다
        // 버튼과 같은 View 가 클릭되었을때 실행될 listener 를 등록하는 메소드가 setOnClickListener 이다.
        button.setOnClickListener {
            // MainActivity 를 시작하는 Intent 를 생성한다
            val intent = Intent(this@TestActivity, MainActivity::class.java)
            // intent 를 사용하여 Activity 를 시작한다
            startActivity(intent)
        }
        // CONSTELLATION ACTIVITY 버튼을 누른경우 동작하는 이벤트 리스너를 등록한다.
        button2.setOnClickListener {
            // ConstellationActivity 를 시작하는 Intent 를 생성한다.
            val intent = Intent(this@TestActivity, ConstellationActivity::class.java)
            // intent 를 사용하여 Activity 를 시작한다
            startActivity(intent)
        }

        // NAME ACTIVITY 버튼을 누른 경우 동작하는 이벤트 리스너를 등록한다.
        button3.setOnClickListener {
            // NameActivity 를 시작하는 Intent 를 생성한다
            val intent = Intent(this@TestActivity, NameActivity::class.java)
            // intent 를 사용하여 Activity 를 시작한다
            startActivity(intent)
        }
        // RESULT ACTIVITY 버튼을 누른 경우 동작하는 이벤트 리스너를 등록한다.
        button4.setOnClickListener {
            // RESULT ACTIVITY 를 시작하는 Intent 를 생성한다
            val intent = Intent(this@TestActivity, ResultActivity::class.java)
            // intent 를 사용하여 Activity 를 시작한다.
            startActivity(intent)
        }
    }

    /**
     * xml 에서 참조할수 있게 메소드를 정의한다.
     */
    fun goConstellation(view: View) {
        val intent = Intent(this@TestActivity, ConstellationActivity::class.java)
        startActivity(intent)
    }

    // 암시적 인텐트를 사용해 웹브라우저를 호출한다
    fun callWeb(view: View){
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.naver.com"))
                startActivity(intent)
    }
}