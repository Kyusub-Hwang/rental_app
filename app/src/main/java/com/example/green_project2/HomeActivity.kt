package com.example.green_project2

import android.Manifest.permission.CAMERA
import android.Manifest.permission.READ_EXTERNAL_STORAGE
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.google.zxing.integration.android.IntentIntegrator
import kotlinx.android.synthetic.main.activity_home.*
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*



class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }

    fun qrRegister(view: View) {
        IntentIntegrator(this).initiateScan()
    }

    fun serviceStart(){
        val sdf = SimpleDateFormat("yyyy/M/dd hh:mm:ss")
        val currentDate = sdf.format(Date())
        tv_startTime.text = currentDate
        tv_useTime.text = "0시간"
        tv_fee.text = "1,000원 (24시간까지)"
        returnBtn.isVisible=true
        itemInfo.isVisible=true
        itemInfo.text="비밀번호는 137입니다.\n(이용중인 우산 #${umbrellaID})"
    }

    fun serviceEnd(view: View){
        tv_startTime.text = "N/A"
        tv_useTime.text = "N/A"
        tv_fee.text = "N/A"
        Toast.makeText(this, "1,000원 결제완료", Toast.LENGTH_SHORT).show()
        dispatchTakePictureIntent()
        returnBtn.isVisible=false
    }

    var umbrellaID : Any? = null

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {
        val result =
            IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if (result != null) {
            if (result.contents == null) {
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "스캔성공 #" + result.contents, Toast.LENGTH_LONG).show()
                umbrellaID = result.contents
                serviceStart()
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

    val REQUEST_IMAGE_CAPTURE = 1

    private fun dispatchTakePictureIntent() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            takePictureIntent.resolveActivity(packageManager)?.also {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
            }
        }
    }



}