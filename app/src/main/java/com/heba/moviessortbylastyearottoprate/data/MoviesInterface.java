package com.heba.moviessortbylastyearottoprate.data;

import com.heba.moviessortbylastyearottoprate.pojo.TopDataDetails;

import java.io.Serializable;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MoviesInterface extends Serializable {
    @GET("/API/Top250Movies/{apiKey}")
    public Call<TopDataDetails> getItems();
}
