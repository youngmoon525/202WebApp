package com.example.lastproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.conn.ApiClient;
import com.example.conn.CommonMethod;
import com.kakao.sdk.auth.model.OAuthToken;
import com.kakao.sdk.common.KakaoSdk;
import com.kakao.sdk.user.UserApiClient;
import com.kakao.sdk.user.model.User;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

public class LoginActivity extends AppCompatActivity {
    Button btn_login;
    EditText edt_id , edt_pw;
    ImageView imgv_kakao_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ApiClient.setBASEURL("http://192.168.0.38/middle/");

        KakaoSdk.init(this, "baba4d095202e023b2e4b5bb3eb322e1");

        imgv_kakao_login = findViewById(R.id.imgv_kakao_login);
        btn_login = findViewById(R.id.btn_login);
        edt_id = findViewById(R.id.edt_id);
        edt_pw = findViewById(R.id.edt_pw);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    //로그인 처리가 스프링에서 끝났다면 => 안드에서 요청해보기.(login.me)
                    //로그인 처리가 정상적으로 된다면 => Vo값 하나를 가져올수있다면
                    // 로그 찍어보기.
                new CommonMethod().setParams("email" , edt_id.getText().toString())
                        .setParams("pw" , edt_pw.getText().toString())
                        .sendPost("login.me", new CommonMethod.CallBackResult() {
                            @Override
                            public void result(boolean isResult, String data) {
                                Log.d("로그", "result: " + data);
                            }
                        });

            }
        });

        imgv_kakao_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kakaoLogin();//카카오 로그인 메소드 호출
            }
        });

        //getHashKey();
    }



    //     /XDE9Iz6D0dcCi0rgEfw6jTOvFw=
    private void getHashKey(){
        PackageInfo packageInfo = null;
        try {
            packageInfo = getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_SIGNATURES);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        if (packageInfo == null)
            Log.e("KeyHash", "KeyHash:null");

        for (Signature signature : packageInfo.signatures) {
            try {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("로그", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            } catch (NoSuchAlgorithmException e) {
                Log.e("로그", "Unable to get MessageDigest. signature=" + signature, e);
            }
        }
    }

    // 크롬이 안켜지면 => 크롬 사용중지 후 진행
    private void kakaoLogin(){
        // 카카오톡이 설치되어 있으면 카카오톡으로 로그인, 아니면 카카오계정으로 로그인
        Function2<OAuthToken, Throwable, Unit> callback = new Function2<OAuthToken, Throwable, Unit>() {
            @Override
            public Unit invoke(OAuthToken oAuthToken, Throwable throwable) {
                if(oAuthToken != null){
                    Log.d("로그", "invoke: " + oAuthToken.toString());
                    UserApiClient.getInstance().me(new Function2<User, Throwable, Unit>() {
                        @Override
                        public Unit invoke(User user, Throwable throwable) {
                            Log.d("로그", "invoke: " + user.getId());
                            Log.d("로그", "invoke: " + user.getKakaoAccount().getEmail());
                            Log.d("로그", "invoke: " + user.getKakaoAccount().getProfile().getThumbnailImageUrl());
                            socialLogin(user.getKakaoAccount().getEmail());
                            return null;
                        }
                    });
                }

                return null;
            }
        };
        if (UserApiClient.getInstance().isKakaoTalkLoginAvailable(this)) {
            UserApiClient.getInstance().loginWithKakaoTalk(this,callback);
        }else{
            UserApiClient.getInstance().loginWithKakaoAccount(this,callback);
        }

    }

    public void socialLogin(String email){
        Log.d("로그", "socialLogin: " + email);
        new CommonMethod().setParams("email" , email)
                .sendPost("social.me", new CommonMethod.CallBackResult() {
                    @Override
                    public void result(boolean isResult, String data) {

                    }
                });
        // 소셜 로그인을 통해서 가져온 정보(이메일)를 Spring으로 전송하기.( oracle테이블에 해당하는 메일로 가입한 정보 )
        // AndMemberController에서 받게 처리.
        // 1. 가입한 정보가 있다면 로그인 성공 처리
        // 2. 가입한 정보가 없다면 회원가입 처리
    }

}