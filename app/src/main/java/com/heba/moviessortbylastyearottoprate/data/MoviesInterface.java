package com.heba.moviessortbylastyearottoprate.data;

import com.heba.moviessortbylastyearottoprate.pojo.TopDataDetails;

import java.io.Serializable;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MoviesInterface {
    @GET("/API/Top250Movies/k_vizmc9cr")
    public Call<TopDataDetails> getItems();
}
