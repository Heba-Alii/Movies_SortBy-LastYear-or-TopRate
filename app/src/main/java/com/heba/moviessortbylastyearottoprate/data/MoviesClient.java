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
        OkHttpClient okClient = new OkHttpClient.Builder()
                .addInterceptor(
                        new Interceptor() {
                            @Override
                            public Response intercept(Interceptor.Chain chain) throws IOException {
                                Request originalRequest = chain.request();
                                HttpUrl originalUrl = originalRequest.url();
                                HttpUrl url = originalUrl.newBuilder()
                                        .addQueryParameter("apiKey", "k_vizmc9cr")
                                        .build();
                                Request.Builder requestBuilder = originalRequest.newBuilder().url(url);
                                Request request = requestBuilder.build();
                                return chain.proceed(request);
                            }
                        })
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okClient)
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
