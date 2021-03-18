package com.akj.quizlocker

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_file_ex.*
import java.io.File
import java.io.FileInputStream
import java.io.FileNotFoundException
import java.io.FileOutputStream

class FileExActivity : AppCompatActivity() {
    // 데이터 저장에 사용할 파일이름
    val filename = "data.txt"
    // 권한이 있는지 저장하는 변수
    var granted = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_file_ex)
        // 외부저장소의 권한을 동적으로 체크하는 함수를 호출
        checkPermission()
        // 저장 버튼이 클릭된 경우
        saveButton.setOnClickListener {
            // textField 의 현재 텍스트를 가져온다.
            val text = textField.text.toString()
            when {
                // 텍스트가 비어있는 경우 오류 메세지를 보여준다.
                TextUtils.isEmpty(text) -> {
                    Toast.makeText(applicationContext, "텍스트가 비어있습니다.", Toast.LENGTH_LONG).show()
                }
                !isExternalStorageWritable() -> {
                    Toast.makeText(applicationContext, "외부 저장장치가 없습니다.", Toast.LENGTH_LONG).show()
                }
                else -> {
                    // 내부 저장소 파일에 저장하는 함수 호출
                    //saveToInnerStorage(text, filename)
                    // 외부 저장소 파일에 저장하는 함수 호출
                    // saveToExternalStorage(text, filename)

                    // 외부저장소"/sdcard/data.txt" 에 데이터를 저장
                    saveToExternalCustomDirectory(text)
                }
            }
        }
        // 불러오기 버튼이 클릭된 경우
        loadButton.setOnClickListener {
            try {
                // textField 의 텍스트를 불러온 텍스트로 설정한다.
                // textField.setText(loadFromInnerStorage(filename))
                // 외부저장소 앱전용 디렉토리의 파일에서 읽어온 데이터로 textField 의 텍스트를 설정
                // textField.setText(loadFromExternalStorage(filename))

                // 외부저장소 "/sdcard/data.txt" 에서 데이터를 불러온다
                textField.setText(loadFromExternalCustomDirectory())
            } catch (e: FileNotFoundException) {
                // 파일이 없는 경우 에러메세지 보여줌
                Toast.makeText(applicationContext, "저장된 텍스트가 없습니다.", Toast.LENGTH_LONG).show()
            }
        }
    }

    // 내부저장소 파일의 텍스트를 저장한다.
    fun saveToInnerStorage(text: String, filename: String) {
        // 내부 저장소의 전달된 파일이름의 파일 출력 스트림을 가져온다.
        val fileOutputStream = openFileOutput(filename, Context.MODE_PRIVATE)
        // 파일 출력 스트림에 text 를 바이트로 변환하여 write 한다
        fileOutputStream.write(text.toByteArray())
        // 파일 출력 스트림을 닫는다
        fileOutputStream.close()
    }

    // 내부저장소 파일의 텍스트를 불러온다
    fun loadFromInnerStorage(filename: String): String {
        // 내부저장소의 전달된 파일이름의 파일 입력 스트림을 가져온다
        val fileInputStream = openFileInput(filename)
        // 파일의 저장된 내용을 읽어 String 형태로 불러온다.
        return fileInputStream.reader().readText()
    }

    // 외부 저장장치를 사용할 수 있고 쓸수 있는지 체크하는 함수
    fun isExternalStorageWritable(): Boolean {
        when {
            // 외부저장장치 상태가 MEDIA_MONTED 면 사용 가능
            Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED -> return true
            else -> return false
        }
    }

    // 외부저장장치에서 앱 전용데이터로 사용할 파일 객체를 반환하는 함수
    fun getAppDataFileFromExternalStorage(filename: String): File {
        // KITKAT 버전 부터는 앱전용 디렉토리의 디렉토리 타입 상수인 Environment.DIRECTORY_DOCUMENTS 를 지원
        val dir = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS)
        } else {
            // 하위 버전에서는 직접 디렉토리 이름 입력
            File(Environment.getExternalStorageDirectory().absolutePath + "/Documents")
        }
        // 디렉토리의 경로중 없는 디렉토리가 있다면 생성한다.
        dir?.mkdirs()
        return File("${dir.absolutePath}${File.separator}${filename}")
    }

    // 외부저장소 앱 전용 디렉토리에 파일로 저장하는 함수
    fun saveToExternalStorage(text: String, filename: String) {
        val fileOutputStream = FileOutputStream(getAppDataFileFromExternalStorage(filename))
        fileOutputStream.write(text.toByteArray())
        fileOutputStream.close()
    }

    // 외부저장소 앱 전용 디렉토리에서 파일 데이터를 불러오는 함수
    fun loadFromExternalStorage(filename: String): String {
        return FileInputStream(getAppDataFileFromExternalStorage(filename)).reader().readText()
    }

    // 권한요청시 사용할 요청 코드
    val MY_PERMISSION_REQUEST = 999


    // 권한 체크및 요청 함수
    fun checkPermission() {
        val permissionCheck = ContextCompat.checkSelfPermission(this@FileExActivity,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
        when {
            permissionCheck != PackageManager.PERMISSION_GRANTED -> {
                // 권한을 요청
                ActivityCompat.requestPermissions(
                        this@FileExActivity,
                        arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                        MY_PERMISSION_REQUEST
                )
            }
        }
    }

    // 권한요청 결과 컬백 함수
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults:
    IntArray) {
        when (requestCode) {
            MY_PERMISSION_REQUEST -> {
                when {
                    grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED -> {
                        // 권한 요청 성공
                        granted = true
                    }
                    else -> {
                        // 사용자가 권한을 허용하지 않음
                        granted = false
                    }
                }
            }
        }
    }
    // 임의의 경로의 파일에 데이터를 저장하는 함수
    fun saveToExternalCustomDirectory(text: String, filepath: String = "/sdcard/data.txt") {
        when {
            // 권한이 있는 경우
            granted -> {
                // 파라미터로 전달받은 경로의 파일의 출력 스트림 객체를 생성
                val fileOutputStream = FileOutputStream(File(filepath))
                fileOutputStream.write(text.toByteArray())
                fileOutputStream.close()
            }
            // 권한이 없는 경우
            else -> {
                Toast.makeText(applicationContext, "권한이 없습니다.", Toast.LENGTH_SHORT).show()
            }
        }
    }
    // 임의의 경로에 파일에서 데이터를 읽는 함수
    fun loadFromExternalCustomDirectory(filepath: String = "/sdcard/data.txt"): String {
        when {
            // 권한이 있는 경우
            granted -> {
                return FileInputStream(File(filepath)).reader().readText()
            }
            // 권한이 없는 경우
            else -> {
                Toast.makeText(applicationContext, "권한이 없습니다.", Toast.LENGTH_SHORT).show()
                return ""
            }
        }
    }
}