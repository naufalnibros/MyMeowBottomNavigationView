package com.codeinger.mymeowbottomnavigationview.api;

import com.codeinger.mymeowbottomnavigationview.data.TampilSemua;
import com.codeinger.mymeowbottomnavigationview.data.model.login.Login;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("login.php")
    Call<Login> loginResponse(
            @Field("username") String username,
            @Field("password") String password
    );

    @GET("tampil_semua.php")
    Call<List<TampilSemua>> sampleTampilSemua();
}
