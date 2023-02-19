package com.heba.moviessortbylastyearottoprate.ui.movieDetails;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
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
import com.heba.moviessortbylastyearottoprate.pojo.ItemsModel;
import com.heba.moviessortbylastyearottoprate.pojo.TopDataDetails;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;

public class MovieFragment extends Fragment {
    private FragmentMovieBinding binding;
    public MovieViewModel mViewModel;
    private MovieDetailsAdapter movieDetailsAdapter;
    private ArrayList<ItemsModel> movies;

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
        initView();
        mViewModel.moviesListMutableLiveData.observe(getViewLifecycleOwner(), new Observer<TopDataDetails>() {
            @Override
            public void onChanged(TopDataDetails topDataDetails) {
                movies = topDataDetails.getItems();
                sortMoviesByLastYear(movies);
                movieDetailsAdapter.setList(movies);
            }
        });
        return root;
    }

    public void initView() {
        binding.moviesTabs.addTab(binding.moviesTabs.newTab().setText("Year"));
        binding.moviesTabs.addTab(binding.moviesTabs.newTab().setText("Rate"));
        binding.moviesTabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                if (position == 0) {
                    sortMoviesByLastYear(movies);
                } else if (position == 1) {
                    sortMoviesByTopRate(movies);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }


    @SuppressLint("NotifyDataSetChanged")
    public ArrayList<ItemsModel> sortMoviesByLastYear(ArrayList<ItemsModel> items) {
        Comparator<ItemsModel> lastYearComparator = new Comparator<ItemsModel>() {
            @Override
            public int compare(ItemsModel o1, ItemsModel o2) {
                return o2.getYear().compareTo(o1.getYear());
            }
        };

        Collections.sort(items, lastYearComparator);
        movieDetailsAdapter.notifyDataSetChanged();
        return items;
    }

    @SuppressLint("NotifyDataSetChanged")
    public ArrayList<ItemsModel> sortMoviesByTopRate(ArrayList<ItemsModel> items) {
        Comparator<ItemsModel> lastYearComparator = new Comparator<ItemsModel>() {
            @Override
            public int compare(ItemsModel o1, ItemsModel o2) {

                return o2.getImDbRating().compareTo(o1.getImDbRating());
            }
        };

        Collections.sort(items, lastYearComparator);
        movieDetailsAdapter.notifyDataSetChanged();
        return items;
    }
}