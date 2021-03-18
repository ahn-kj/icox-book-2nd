package com.akj.kotlinsample;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class VariableJavaActivity extends AppCompatActivity {

    // 버튼이 클릭된 횟수를 저장할 변수
    int clickCount = 0;
    // Activity 의 시작시간을 저장하는 변수
    final long startTime = System.currentTimeMillis();
    // Activity 시작 시간을 보여주는 TextView
    TextView startTimeLabel;
    // 클릭된 횟수를 보여주는 TextView
    TextView clickCountLabel;
    // 클릭 버튼
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // UI 로 사용할 XML 파일을 지정한다.
        setContentView(R.layout.layout_variable);

        // 레이아웃에서 startTimeLabel 을 찾아 바인딩한다.
        startTimeLabel = findViewById(R.id.startTimeLabel);

        // 레이아웃에서 clickCountLabel 을 찾아 바인딩한다.
        clickCountLabel = findViewById(R.id.clickCountLabel);

        // 레이아웃에서 button 을 찾아 바인딩한다.
        button = findViewById(R.id.button);

        // 시작시간을 텍스트 형태로 변환
        String timeText = new SimpleDateFormat("HH:mm:ss", Locale.KOREA).format(startTime);

        // 시작시간을 TextView 에 보여줌
        startTimeLabel.setText("Activity 시작시간: " + timeText);

        // 클릭된 횟수 보여줌
        clickCountLabel.setText("버튼이 클릭된 횟수:" + clickCount);

        // 버튼에 이벤트 리스너 등록
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { // 클릭된 횟수 추가
                clickCount = clickCount + 1;
                // UI 에 클릭횟수 다시 보여줌
                clickCountLabel.setText("버튼이 클릭된 횟수: " + clickCount);
            }
        });
    }
}
