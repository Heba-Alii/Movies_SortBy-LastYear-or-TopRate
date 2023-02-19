package com.heba.moviessortbylastyearottoprate.ui.movieDetails;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.heba.moviessortbylastyearottoprate.data.MoviesClient;
import com.heba.moviessortbylastyearottoprate.pojo.TopDataDetails;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieViewModel extends ViewModel {

    MutableLiveData<TopDataDetails> moviesListMutableLiveData = new MutableLiveData<>();
    public void getData() {
        Call<TopDataDetails> call = MoviesClient.getINSTANCE().getItems().getItems();
        call.enqueue(new Callback<TopDataDetails>() {
            @Override
            public void onResponse(Call<TopDataDetails> call, Response<TopDataDetails> response) {
                moviesListMutableLiveData.setValue(response.body());
                if (response.isSuccessful()) {
                    Log.d("TAG", "onResponse:success " + response.body().getItems());
                }
            }

            @Override
            public void onFailure(Call<TopDataDetails> call, Throwable t) {
                Log.d("TAG", "onFailure: not Success" + t.getMessage());
            }
        });
    }

}