package com.akj.quizlocker

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.graphics.Color
import android.os.Build
import android.os.IBinder

class LockScreenService : Service() {
    // 화면이 꺼질때 브로드캐스트 메세지를 수신하는 리시버
    var receiver: ScreenOffReceiver? = null
    private val ANDROID_CHANNEL_ID = "com.akj.quizlocker"
    private val NOTIFICATION_ID = 9999
    // 서비스가 최초 생성될때 컬백 함수
    override fun onCreate() {
        super.onCreate()
        // 브로드캐스트 리시버가 null 인 경우에만 실행
        if (receiver == null) {
            receiver = ScreenOffReceiver()
            val filter = IntentFilter(Intent.ACTION_SCREEN_OFF)
            registerReceiver(receiver, filter)
        }
    }

    // 서비스를 호출하는 클라이언트가 startService() 함수를 호출할때마다 불리는 컬백함수
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        super.onStartCommand(intent, flags, startId)
        if (intent != null) {
            if (intent.action == null) {
                // 서비스가 최초 실행이 아닌 경우 onCreate 가 불리지 않을 수 있음.
                // 이 경우 receiver 가 널이면 새로 생성하고 등록한다.
                if (receiver == null) {
                    receiver = ScreenOffReceiver()
                    val filter = IntentFilter(
                            Intent.ACTION_SCREEN_OFF)
                    registerReceiver(receiver, filter)
                }
            }
        }
        // 안드로이드 오레오 버전부터 백그라운드 제약이 있기 때문에 포그라운드 서비스를 실행해야함.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // Notification(상단 알림) 채널 생성
            val chan = NotificationChannel(ANDROID_CHANNEL_ID, "MyService", NotificationManager.IMPORTANCE_NONE)
            chan.lightColor = Color.BLUE
            chan.lockscreenVisibility = Notification.VISIBILITY_PRIVATE
            // Notification 서비스 객체를 가져옴
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(chan)
            // Notification 알림 객체 생성
            val builder = Notification.Builder(this, ANDROID_CHANNEL_ID)
                    .setContentTitle(getString(R.string.app_name))
                    .setContentText("SmartTracker Running")
            val notification = builder.build()
            // Notification 알림과 함께 포그라운드 서비스 시작
            startForeground(NOTIFICATION_ID, notification)
        }
        return Service.START_REDELIVER_INTENT
    }

    override fun onDestroy() {
        super.onDestroy()
        // 서비스가 종료될때 브로드캐스트 리시버 등록도 해제
        if (receiver != null) {
            unregisterReceiver(receiver)
        }
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }
}