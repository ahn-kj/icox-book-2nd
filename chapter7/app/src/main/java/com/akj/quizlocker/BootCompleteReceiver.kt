package com.akj.quizlocker

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.preference.PreferenceManager
import android.util.Log

// BroadcastReceiver 를 상속받는다
class BootCompleteReceiver : BroadcastReceiver() {
    // 브로드캐스트 메세지 수신시 불리는 컬백 함수
    override fun onReceive(context: Context?, intent: Intent?) {
        when {
            // 부팅이 완료될때의 메세지인지 확인
            intent?.action == Intent.ACTION_BOOT_COMPLETED -> {
                Log.d("quizlocker", "부팅이 완료됨")
                context?.let {
                    // 퀴즈잠금화면 설정값이 ON 인지 확인
                    val pref = PreferenceManager.getDefaultSharedPreferences(context)
                    val useLockScreen = pref.getBoolean("useLockScreen", false)
                    if (useLockScreen) {
                        // LockScreenService 시작
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                            it.startForegroundService(Intent(context, LockScreenService::class.java))
                        } else {
                            it.startService(Intent(context, LockScreenService::class.java))
                        }
                    }
                }
            }
        }
    }
}