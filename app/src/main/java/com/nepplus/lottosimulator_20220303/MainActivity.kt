package com.nepplus.lottosimulator_20220303

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupEvents()
        setValues()
    }

    private fun setupEvents(){

        btnBuyLotto.setOnClickListener {

            buyLotto()
        }
    }

    private fun buyLotto(){

        // 6개의 당첨번호 생성
        // 코틀린의 for문은, for-each 문법으로 기반

        for (i in 0..5 ){
            Log.d("반복문확인",i.toString())
        }

        // 만들어진 당첨번호 6개를  -> 텍스트뷰에 표현
        
        // 보너스번호 생성
        
        // 텍스트뷰에 배치
        
    }

    private fun setValues(){


    }
}