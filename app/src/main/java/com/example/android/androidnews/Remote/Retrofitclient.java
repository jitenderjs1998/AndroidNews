package com.example.android.androidnews.Remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hp on 11/15/2017.
 */

public class Retrofitclient {
    private static Retrofit retrofit=null;
    public static Retrofit getClient(String baseUrl){
        if(retrofit == null)
        {
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
