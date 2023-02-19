package com.heba.moviessortbylastyearottoprate.ui.movieDetails;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.heba.moviessortbylastyearottoprate.R;
import com.heba.moviessortbylastyearottoprate.databinding.FragmentMovieBinding;
import com.heba.moviessortbylastyearottoprate.pojo.TopDataDetails;

public class MovieFragment extends Fragment {
    private FragmentMovieBinding binding;
    public MovieViewModel mViewModel;
    private MovieDetailsAdapter movieDetailsAdapter;

    public static MovieFragment newInstance() {
        return new MovieFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentMovieBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        mViewModel = ViewModelProviders.of(this).get(MovieViewModel.class);
        mViewModel.getData();
        movieDetailsAdapter = new MovieDetailsAdapter();
        binding.moviesRV.setAdapter(movieDetailsAdapter);
        mViewModel.moviesListMutableLiveData.observe(getViewLifecycleOwner(), new Observer<TopDataDetails>() {
            @Override
            public void onChanged(TopDataDetails topDataDetails) {
                Log.d("TAG", "onChanged: get data");
                movieDetailsAdapter.setList(topDataDetails.getItems());
                Log.d("TAG", "onChanged: get data item");
            }
        });
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MovieViewModel.class);
        // TODO: Use the ViewModel
    }

}