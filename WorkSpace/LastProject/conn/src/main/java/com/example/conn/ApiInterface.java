package com.example.conn;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface ApiInterface {

    // get 또는 post 등 여러가지 방식의 요청을 미리 지정을 해놓고
    // 계속해서 새로 초기화해서 사용함.

    @FormUrlEncoded // URL을 가변적으로 바꿔서 요청 받게 처리(mapping)
    @POST // 요청방식 POST
    Call<String> connPost(@Url String url , @FieldMap HashMap<String,Object> params);

    // url과 param가 전부 노출되는 형태 <> Post
    @GET("{path}")
    Call<String> connGet(@Path("path") String url , @QueryMap HashMap<String,Object> params);


//    public interface GitHubService {
//        @GET("users/{user}/repos")
//        Call<List<Repo>> listRepos(@Path("user") String user);
//    }
}
