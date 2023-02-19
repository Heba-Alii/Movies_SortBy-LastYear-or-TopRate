package com.heba.moviessortbylastyearottoprate.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.heba.moviessortbylastyearottoprate.R;
import com.heba.moviessortbylastyearottoprate.databinding.ActivityMainBinding;
import com.heba.moviessortbylastyearottoprate.ui.movieDetails.MovieFragment;

public class MainActivity extends AppCompatActivity {
    Fragment replaceFragment;
    private ActivityMainBinding binding;
    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        manager = getSupportFragmentManager();
        replaceFragment = new MovieFragment();
        manager.beginTransaction().replace(R.id.fragmentContainerView, replaceFragment).commit();

    }
}