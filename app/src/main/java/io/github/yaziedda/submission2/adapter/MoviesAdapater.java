package io.github.yaziedda.submission2.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import io.github.yaziedda.submission2.R;
import io.github.yaziedda.submission2.model.Movies;

public class MoviesAdapater extends RecyclerView.Adapter<MoviesAdapater.ViewHolder> {

    List<Movies> list = new ArrayList<>();
    boolean horizontal = false;

    public interface OnItemClickListener {
        void onItemClick(Movies model);
    }

    private final OnItemClickListener listener;

    public MoviesAdapater(List<Movies> list, OnItemClickListener listener, boolean horizontal) {
        this.list = list;
        this.listener = listener;
        this.horizontal = horizontal;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movies, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Movies model = list.get(position);

        holder.tvTitle.setText(model.getTitle());
        holder.tvDesc.setText(model.getDescription());
        holder.tvRelease.setText(model.getRelease());

        Glide.with(holder.itemView.getContext())
                .load(model.getImageUrl())
                .centerCrop()
                .placeholder(R.drawable.logo)
                .into(holder.ivImage);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(model);
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle;
        TextView tvDesc;
        TextView tvRelease;
        ImageView ivImage;


        public ViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvDesc = itemView.findViewById(R.id.tv_desc);
            tvRelease = itemView.findViewById(R.id.tv_release);
            ivImage = itemView.findViewById(R.id.img);
        }
    }
}

