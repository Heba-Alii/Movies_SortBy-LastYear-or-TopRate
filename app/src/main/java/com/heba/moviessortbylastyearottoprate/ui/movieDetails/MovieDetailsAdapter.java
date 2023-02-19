package com.heba.moviessortbylastyearottoprate.ui.movieDetails;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.heba.moviessortbylastyearottoprate.R;
import com.heba.moviessortbylastyearottoprate.pojo.ItemsModel;

import java.util.ArrayList;
//import eg.gov.iti.recyclerview.R;
//import eg.gov.iti.recyclerview.pojo.ItemsModel;

public class MovieDetailsAdapter extends RecyclerView.Adapter<MovieDetailsAdapter.MovieDetailsViewHolder> {
    private ArrayList<ItemsModel> moviesList = new ArrayList<>();

    @NonNull
    @Override
    public MovieDetailsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MovieDetailsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_details, parent, false));
    }


    @Override
    public void onBindViewHolder(@NonNull MovieDetailsViewHolder holder, int position) {
        ItemsModel itemsModel = moviesList.get(position);
        holder.movie_title.setText(itemsModel.getTitle());
        holder.movies_date.setText(itemsModel.getYear());
        holder.movies_rate.setText(itemsModel.getImDbRating() + "/10 IMDB");
        Glide.with(holder.itemView)
                .load(itemsModel.getImage()).fitCenter().into(holder.movie_image);


    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    public void setList(ArrayList<ItemsModel> moviesList) {
        this.moviesList = moviesList;
        notifyDataSetChanged();
    }

    public class MovieDetailsViewHolder extends RecyclerView.ViewHolder {
        ImageView movie_image;
        TextView movie_title;
        TextView movies_date;
        TextView movies_time;
        TextView movies_rate;


        public MovieDetailsViewHolder(@NonNull View itemView) {
            super(itemView);
            movie_image = itemView.findViewById(R.id.movie_image);
            movie_title = itemView.findViewById(R.id.movie_title);
            movies_date = itemView.findViewById(R.id.movies_date);
            movies_time = itemView.findViewById(R.id.movies_time);
            movies_rate = itemView.findViewById(R.id.movies_rate);

        }
    }
}