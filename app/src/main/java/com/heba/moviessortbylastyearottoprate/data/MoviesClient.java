package com.heba.moviessortbylastyearottoprate.data;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MoviesClient {
    private static final String BASE_URL = "https://imdb-api.com";
    private MoviesInterface moviesInterface;
    private static MoviesClient INSTANCE;

    public MoviesClient() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        moviesInterface = retrofit.create(MoviesInterface.class);

    }

    public static MoviesClient getINSTANCE() {
        if (null == INSTANCE) {
            INSTANCE = new MoviesClient();
        }
        return INSTANCE;
    }

    public MoviesInterface getItems() {
        return moviesInterface;
    }
}
