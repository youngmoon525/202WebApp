package com.example.conn;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CommonMethod {
    // 해당하는 getData라는 메소드를 여러 액티비티와 프래그먼트에서 재활용을 통해
    // Spring에 연결 후 데이터를 가지고 오는 처리를 해야함.
    // 어떤식으로 바뀌면 재활용이 편할까???
    private HashMap<String , Object> params = new HashMap<>();
    public CommonMethod setParams(String key , String value){
        params.put(key,value);
        return this;
    }

    public void sendPost(String url , CallBackResult callback){
        ApiInterface apiInterface = new ApiClient().getApiClient().create(ApiInterface.class);
        Call<String> apiTest =  apiInterface.connPost(url , params);
        apiTest.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                callback.result(true , response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                callback.result(false , "");
                t.printStackTrace();//<=어떤오류인지 로그에 찍히게 처리.
            }
        });
    }

    public void sendGet(String url , CallBackResult callback){
        ApiInterface apiInterface = new ApiClient().getApiClient().create(ApiInterface.class);
        Call<String> apiTest =  apiInterface.connGet(url , params);
        apiTest.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                callback.result(true , response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                callback.result(false , "");
                t.printStackTrace();//<=어떤오류인지 로그에 찍히게 처리.
            }
        });
    }

    //1.정의
    public interface CallBackResult{
        // 메인에서 CommonMethod를 통해서 Callback<String> 인터페이스를 넘겨서 실행할때마다
        // 두개의 메소드가 오버라이드가 됨. ( onResponse , onFailure )==> 하나로 합치고싶음.
        public void result(boolean isResult , String data);
    }

}
