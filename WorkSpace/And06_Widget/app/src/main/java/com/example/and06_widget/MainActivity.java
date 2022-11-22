package com.example.and06_widget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tv_text; //= findViewById(R.id.tv_text);
    Button btn_text, btn_login; //= findViewById(R.id.btn_text);
    RadioButton rdo_1, rdo_2;
    RadioGroup rdo_grp;
    EditText edt_id, edt_pw;
    // ↑ 오류코드 : Why? : 수명주기(Life Cycle) : onCreate
    // setContentView<= 디자인 파일과 연결되는 구간.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_login = findViewById(R.id.btn_login);
        edt_id = findViewById(R.id.edt_id);
        edt_pw = findViewById(R.id.edt_pw);
        // edt_id에 현재 입력 된 값을 가져오는 메소드는 edt_id.getText()
        // btn_login이 클릭이 되면 edt_id의값이 admin 이고 edt_pw의 값이 1234 일때 로그인이 되게 처리해보기.
        // 로그인==> 로그에 로그인이 되었습니다.
        // 그외에는 아이디 또는 비밀번호를 확인해주세요.
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rtn_str();
                method();
                Log.d("로그", "onClick: " + edt_id.getText());
                Log.d("로그", "onClick: " + edt_pw.getText());
                if (edt_id.getText().toString().equals("admin") &&
                        edt_pw.getText().toString().equals("1234")
                ) {
                    Log.d("로그", "로그인 되었습니다.");
                } else {
                    Log.d("로그", "아이디 또는 비밀번호가 틀렸습니다.");
                }
            }
        });


        //※ 사용자 : edt_pw 에 어떤값이든 입력을 할 예정
        // 메소드를 이용해서 해당하는 edt_pw 위젯에 있는값이 숫자이면 로그인을 진행하고
        // 그게아니라면 숫자만 입력해주세요 라는 메세지가 콘솔에 출력되게 처리

        //edt_pw에 입력 된 값이 숫자인지를 판단해서 해당하는 숫자를 리턴하는 메소드!

        tv_text = findViewById(R.id.tv_text);
        btn_text = findViewById(R.id.btn_text);
        //모든위젯(Button포함) 이 null이 아닌 상태일때.=> Event를 줄수있다.
        // null인 상태는 member 모든것 사용불가. .<-찍고 나오는 모든것들

        rdo_1 = findViewById(R.id.rdo_1);
        rdo_2 = findViewById(R.id.rdo_2);

        rdo_grp = findViewById(R.id.rdo_grp);

        rdo_grp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.d("로그", ": " + group.getCheckedRadioButtonId());
                RadioButton temp_rdo = (RadioButton) group.getChildAt(checkedId - 1);
                Log.d("로그", ": " + temp_rdo.getText());
                // 디버깅 모드를 활용해서 문제를 해결 해보기.
                // 어떤 라디오버튼이 클릭 되었는지 알수있으려면 어떻게 해아할까???
                // 아주 나쁨 ~~~~아주 좋음 까지 선택 된 라디오버튼의 값을 로그에 찍어보기.
            }
        });

        rdo_1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // is <= boolean
                // isChecked <= 해당하는 라디오버튼이 체크 된 상태를 우리한테 넘겨줌.
                // 체크가 되었다면 rdo_2의 체크 상태를 해제하고싶다.?
                //rdo_1.setChecked();
                if (isChecked) {
                    rdo_2.setChecked(false);
                }
            }
        });
        rdo_2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // is <= boolean
                // isChecked <= 해당하는 라디오버튼이 체크 된 상태를 우리한테 넘겨줌.
                // 체크가 되었다면 rdo_2의 체크 상태를 해제하고싶다.?
                if (isChecked) {
                    rdo_1.setChecked(false);
                }
            }
        });

        tv_text.setOnClickListener(this);
        btn_text.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.tv_text) {
            btn_text.setText("텍스트뷰 클릭 됨!!!!");
        } else if (v.getId() == R.id.btn_text) {
            tv_text.setText("텍스트뷰 클릭 됨!!!!");
        }
    }



    // 1. edt_pw에 입력 된 값이 int인지를 판단해서 해당하는 int를 return를 리턴하는 메소드
    // 단 입력 값이 숫자가 아닌경우에는 -1을 return한다.

    // 2. 파라메터로 EditText를 입력받아 입력받은 EditText가 ↑경우인지를 판단하는 메소드
    // int타입을 리턴한다.

    int method() {
        try {
            return Integer.parseInt(edt_pw.getText().toString());
        } catch (Exception e) {
            Log.d("로그", "method: 숫자로 바꿀수없는값이 들어왔다.");
        }
        return -1;
    }


    String rtn_str() {
        try {
            Integer.parseInt(edt_id.getText().toString());
            Log.d("로그", "숫자로 바꿀수없는 문자열을 입력해주세요. ");
            return "error";
        } catch (Exception e) {
            return edt_id.getText()+"";
        }
    }
    //↑ String값이 입력되었을때 숫자가 아니라면 return String을 하는 메소드
    // 숫자라면 String error를 리턴하세요. rtn_str<=-
    // 테스트 케이스 1 : edt_id에 1234입력 => 숫자로 바꿀수없는 문자열을 입력해주세요. 출력 후 error return
    // 테스트 케이스 2 : edt_id에 1234a입력 => 1234a를 리턴


}