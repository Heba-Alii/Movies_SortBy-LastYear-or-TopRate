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

import com.google.android.material.tabs.TabLayout;
import com.heba.moviessortbylastyearottoprate.R;
import com.heba.moviessortbylastyearottoprate.databinding.FragmentMovieBinding;
import com.heba.moviessortbylastyearottoprate.pojo.TopDataDetails;

import java.util.Objects;

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
                movieDetailsAdapter.setList(topDataDetails.getItems());
                binding.moviesTabs.addTab(binding.moviesTabs.newTab().setText("Year"));
                binding.moviesTabs.addTab(binding.moviesTabs.newTab().setText("Rate"));
            }
        });
        return root;
    }

    public void initView() {
        binding.moviesTabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}