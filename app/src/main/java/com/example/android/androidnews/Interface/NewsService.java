package com.example.android.androidnews.Interface;

import com.example.android.androidnews.Model.WebSite;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by hp on 11/15/2017.
 */

public interface NewsService {
    @GET("v1/sources?language=en")
    Call<WebSite> getSources();
}
