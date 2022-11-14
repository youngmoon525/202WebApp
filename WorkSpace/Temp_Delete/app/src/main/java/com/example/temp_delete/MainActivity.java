package com.example.temp_delete;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
// public : 접근제한자
// class : 이름 (객체)
// extends : 상속 => 자식클래스가 필요에 의해서 부모클래스를 선택한것.
// Override & OverLoading :
// Override : 재정의 ( 이미 구현되어있는 부모클래스 내용을 다시 정의해서 쓰는것 )
// OverLoading : 메소드의 이름을 같게하고 파라메터 타입이나 갯수를 달리해서 사용하는것
// protected : 상속을 받아야지만 재정의를 허용함.
public class MainActivity extends AppCompatActivity {

    @Override // main메소드
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Test test = new Test();//인스턴스화 .
        // 멤버라는것들의 접근은 인스턴스화된 객체에서 .<-점을 찍으면 전부 접근가능.
        test.iMethod();
        test.iV1 = 10;
        test.iV2 = 20;

        //Test.sV1 = 10; //메모리에 이미 올라가있는 변수이기때문에 인스턴스화를 통해서 객체를 다시한번
                         //메모리에 올리고 사용할필요가 x
        //test.sV1 = 10;
        //test.sV2 = 20;

        Test.Sub sub = test.new Sub();
        sub.sub_v1 = "aa";
        sub.subMethod();

        Test.sSub.subMethod2();
        Test.sSub.subV2=1;

        Test.sSub ss = new Test.sSub();
        ss.subV1 = "aa";



    }

}