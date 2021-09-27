package com.codeinger.mymeowbottomnavigationview.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static final String BASE_URL = "http://mkelasbalikid.rubyowdwyk-yjr3ojmy061m.p.runcloud.link/";
    public static final String URL_GET_ALL_TUGAS = "http://mkelasbalikid.rubyowdwyk-yjr3ojmy061m.p.runcloud.link/tugas.php";

    private static Retrofit retrofit;

    public static Retrofit getClient() {

        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }

    public static final String JUDUL_TUGAS = "judul";
    public static final String PENGAJAR_TUGAS = "pengajar";
    public static final String TAG_JSON_ARRAY = "result";
}
