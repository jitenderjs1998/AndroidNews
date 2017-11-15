package com.example.android.androidnews.Common;

import com.example.android.androidnews.Interface.IconBetterIdeaService;
import com.example.android.androidnews.Interface.NewsService;
import com.example.android.androidnews.Remote.IconBetterIdeaClient;
import com.example.android.androidnews.Remote.Retrofitclient;

/**
 * Created by hp on 11/15/2017.
 */

public class Common {
    private static final String BASE_URL=" https://newsapi.org/";

    public static final String API_KEY="2ec7d2983aae4c53888b47b52dd56bae";

    public static NewsService getNewsService()
    {
        return Retrofitclient.getClient(BASE_URL).create(NewsService.class);
    }

    public static IconBetterIdeaService getIconService()
    {
        return IconBetterIdeaClient.getClient().create(IconBetterIdeaService.class);
    }
}
