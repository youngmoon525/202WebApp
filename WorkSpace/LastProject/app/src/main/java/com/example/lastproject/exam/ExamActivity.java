package com.example.lastproject.exam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.conn.ApiClient;
import com.example.conn.CommonMethod;
import com.example.lastproject.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;


public class ExamActivity extends AppCompatActivity {
    Button btn1 , btn2 , btn3 , btn4 , btn5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);

        ApiClient.setBASEURL("http://192.168.0.38/middle/");

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);

        btn1.setOnClickListener(v -> { //lamda식 사용 유무 장단점 : 가독성이 떨어지지만 코드가 간결함
        // test1요청 : test1은 데이터를 따로 필요로 하지 않음.(x)
//            new CommonMethod().sendPost("test1", new CommonMethod.CallBackResult() {
//                @Override
//                public void result(boolean isResult, String data) {//<= Spring에서 return을 줘야만 있는부분
//                    Log.d("로그", "result: " + isResult);
//                }
//            });
            new CommonMethod().sendPost("test1" , (isResult, data) -> {
                Log.d("로그", "onCreate: " + isResult);
            });
        });
        //url:middle/test2?param1=value1...2..3
        btn2.setOnClickListener(v->{
            //test2로 3개의 파라메터를 보내고 요청해보기
            new CommonMethod().setParams("str" , "str")
                    .sendPost("test2",(isResult, data) -> {

                    });
        });

        btn3.setOnClickListener(v->{
            //test1 , test2 (차이=!) return이 있음.
            new CommonMethod().sendPost("test3", new CommonMethod.CallBackResult() {
                @Override
                public void result(boolean isResult, String data) {//
                    Log.d("로그", "result: " + data);
                }
            });
        });


        btn4.setOnClickListener(v->{
            new CommonMethod().sendPost("test4", new CommonMethod.CallBackResult() {
                @Override
                public void result(boolean isResult, String data) {
                    Log.d("로그", "result: " + data);
                    //Android에 똑같은 형태의 VO가 있는 상태에서 바꿔보기.
                    VO vo = new Gson().fromJson(data , VO.class);
                    // fromJson(String이나 json으로 되어있는 바꾸고싶은 데이터 , 바꾸고싶은 타입 ) ;
                    Log.d("로그", "result: " + vo.getsVal());
                    Log.d("로그", "result: " + vo.getdVal());
                    Log.d("로그", "result: " + vo.getiVal());
                }
            });

        });

        btn5.setOnClickListener(v->{
            new CommonMethod().sendPost("test5", new CommonMethod.CallBackResult() {
                @Override
                public void result(boolean isResult, String data) {
                    Log.d("로그", "result: " + data);
                    //TypeToken typeToken = new TypeToken()
                    ArrayList<VO> list = new Gson().fromJson(data ,
                            new TypeToken<ArrayList<VO>>(){}.getType());
                    Log.d("로그", "result: " + list.size());
                }
            });
        });
    }



    public class VO{
        private int iVal ; String sVal ;  double dVal;


        public int getiVal() {
            return iVal;
        }


        public void setiVal(int iVal) {
            this.iVal = iVal;
        }


        public String getsVal() {
            return sVal;
        }


        public void setsVal(String sVal) {
            this.sVal = sVal;
        }


        public double getdVal() {
            return dVal;
        }


        public void setdVal(double dVal) {
            this.dVal = dVal;
        }


    }
}