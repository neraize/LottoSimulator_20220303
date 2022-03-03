package com.nepplus.lottosimulator_20220303

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // 내 번호 6개 저장
    // 코틀린은 단순 배열 초기화 int[] arr = {   }; 문법지원X

    // 숫자 목록을 파라미터로 넣으면 -> Array로 만들어주는 함수 실행
    val myNumbers = arrayOf(13, 17, 19, 21, 23,31)

    // 컴퓨터가 뽑은 당첨번호 6개를 저장할 ArrayList
    val mWinNumberList= ArrayList<Int>()
    var mBonusNum =0;  // 보너스 번호는 매 판마다 새로 뽑아야함. 변경소지O, 화면이 어딘지는 줄 필요X. 바로대입하는 var로 만듬


    // 당첨번호를 보여줄 6개의 텍스트뷰를 담아둘 ArrayList
    val mWinNumTextViewList = ArrayList<TextView>()

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

        // ArrayList는 목록을 계속 누적 가능
        // 당첨번호 뽑기 전에, 기존의 당첨번호는 전부 삭제하고 다시뽑자
        mWinNumberList.clear()

        for (i in 0 until 6 ){
//            Log.d("반복문확인",i.toString())
            // 괜찮은 번호가 나올때 까지 무한반복
            while (true){
                // 1~ 45의 랜덤 숫자
                // Math.random()은  0~1 => 45.xxx로 가공 => Int로 캐스팅
                val randomNum= (Math.random()*45+1).toInt()

                // 중복 검사 통과시 while 깨자
                if(!mWinNumberList.contains(randomNum)){
                    // 당첨번호로, 뽑은 랜덤숫자 등록
                    mWinNumberList.add(randomNum)
                    break
                }
            }
        }

        // 만들어진 당첨번호 6개를  -> 작은수 ~ 큰 수로 정리해서  -> 텍스트뷰에 표현
        mWinNumberList.sort() // 자바로 직접 짜던 로직을 -> 객체지향의 특성, 만들어져있는 기능 활용으로 대체

        Log.d("당첨번호목록",mWinNumberList.toString())

//        for(winNum in mWinNumberList){
//            Log.d("당첨번호", winNum.toString())
//        }

        // for > 돌면서,  당첨번호도 / 몇번째 바퀴인지도 필요 => 텍스트뷰를 찾아내야함
        mWinNumberList.forEachIndexed { index, winNum ->
            // 순서에 맞는 텍스트뷰 추출 => 문구로 당첨번호 설정
            mWinNumTextViewList[index].text = winNum.toString()
        }
        
        // 보너스번호 생성 -> 1~45숫자중에 하나 , 당첨번호와 겹치지 않게
        while (true){
            val randomNum = (Math.random()*45+1).toInt()
            if(!mWinNumberList.contains(randomNum)){
                // 겹치지 않는 숫자 뽑아냄
                mBonusNum = randomNum
                break
            }
        }

        // 텍스트뷰에 배치
        txtBonusNum.text = mBonusNum.toString()

        // 내 숫자 6개와 비교, 등수 판정
        checkLottoRank()

    }

    private fun checkLottoRank(){

        // 내번호 목록 vs 당첨 번호 목록중, 같은 숫자가 몇개?
        var correctCount =0


    }


    private fun setValues(){

        mWinNumTextViewList.add(txtWinNum01)
        mWinNumTextViewList.add(txtWinNum02)
        mWinNumTextViewList.add(txtWinNum03)
        mWinNumTextViewList.add(txtWinNum04)
        mWinNumTextViewList.add(txtWinNum05)
        mWinNumTextViewList.add(txtWinNum06)
    }
}