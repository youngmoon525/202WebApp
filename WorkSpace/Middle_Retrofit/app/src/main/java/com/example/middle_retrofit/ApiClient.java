package com.example.middle_retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class ApiClient {


    public Retrofit getApiClient(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.38/middle/") // 톰캣까지(서버 까지 접근 경로)
                .addConverterFactory(ScalarsConverterFactory.create())//json String사용
                .build();


        return retrofit;
    }



}
