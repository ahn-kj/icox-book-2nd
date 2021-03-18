package com.akj.lotto

import android.os.Bundle
import android.text.TextUtils
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_result.*
import java.text.SimpleDateFormat
import java.util.*

class ResultActivity : AppCompatActivity() {
    // 로또 1번 공 이미지의 아이디를 사용
    val lottoImageStartId = R.drawable.ball_01

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        // 전달받은 결과 배열을 가져온다.
        val result = intent.getIntegerArrayListExtra("result")
        // 전달받은 이름을 가져온다.
        val name = intent.getStringExtra("name")
        // 전달받은 별자리를 가져온다
        val constellation = intent.getStringExtra("constellation")
        // 결과화면 기본 텍스트
        resultLabel.text = "랜덤으로 생성된\n로또번호입니다"
        // name 이 전달된 경우 결과화면의 텍스트를 변경
        if (!TextUtils.isEmpty(name)) {
            resultLabel.text = "${name} 님의\n${SimpleDateFormat("yyyy년 MM월 dd일").format(Date())}\n로또 번호입니다"
        }
        // 별자리가 전달된 경우 텍스트 변경
        if (!TextUtils.isEmpty(constellation)) {
            resultLabel.text = "${constellation} 의\n${SimpleDateFormat("yyyy년 MM월 dd일").format(Date())}\n로또 번호입니다"
        }
        // 전달받은 결과가 있는 경우에만 실행
        result?.let {
            // 결과에 맞게 로또 공 이미지를 업데이트한다.
            // 전달받은 결과는 정렬되어 있지않으므로 정렬해서 전달한다.
            updateLottoBallImage(result.sortedBy { it })
        }
    }

    /**
     * 결과에 따라 로또 공 이미지를 업데이트한다.
     */
    fun updateLottoBallImage(result: List<Int>) {
        // 결과의 사이즈가 6개 미만인경우 에러가 발생할 수 있으므로 바로 리턴한다.
        if (result.size < 6) return

        // ball_01 이미지 부터 순서대로 이미지 아이디가 있기 때문에
        // ball_01 아이디에 결과값 -1 을 하면 목표하는 이미지가 된다
        // ex) result[0] 이 2번 공인 경우 ball_01 에서 하나뒤에 이미지가 된다.
        imageView01.setImageResource(lottoImageStartId + (result[0] - 1))
        imageView02.setImageResource(lottoImageStartId + (result[1] - 1))
        imageView03.setImageResource(lottoImageStartId + (result[2] - 1))
        imageView04.setImageResource(lottoImageStartId + (result[3] - 1))
        imageView05.setImageResource(lottoImageStartId + (result[4] - 1))
        imageView06.setImageResource(lottoImageStartId + (result[5] - 1))
    }
}