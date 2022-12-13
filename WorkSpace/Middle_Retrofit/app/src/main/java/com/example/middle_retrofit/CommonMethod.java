package com.example.middle_retrofit;

import android.util.Log;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CommonMethod {
    // 해당하는 getData라는 메소드를 여러 액티비티와 프래그먼트에서 재활용을 통해
    // Spring에 연결 후 데이터를 가지고 오는 처리를 해야함.
    // 어떤식으로 바뀌면 재활용이 편할까???
    private HashMap<String , Object> params = new HashMap<>();
    public void setParams(String key , String value){
        params.put(key,value);
    }

    public void getData(String url , Callback<String> callback){
        ApiInterface apiInterface = new ApiClient().getApiClient().create(ApiInterface.class);
        Call<String> apiTest =  apiInterface.getData(url , params);
        apiTest.enqueue(callback);
    }


}
