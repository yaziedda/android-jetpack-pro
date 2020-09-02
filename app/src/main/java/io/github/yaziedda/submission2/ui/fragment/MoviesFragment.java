package io.github.yaziedda.submission2.ui.fragment;


import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import io.github.yaziedda.submission2.R;
import io.github.yaziedda.submission2.adapter.MoviesAdapater;
import io.github.yaziedda.submission2.model.Movies;
import io.github.yaziedda.submission2.ui.activity.DetailMovieActivity;
import io.github.yaziedda.submission2.ui.activity.DetailTVShowActivity;
import io.github.yaziedda.submission2.viewmodel.MoviesViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class MoviesFragment extends Fragment {


    public MoviesFragment() {
        // Required empty public constructor
    }

    RecyclerView recyclerView;
    MoviesViewModel moviesViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movies, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        moviesViewModel = ViewModelProviders.of(this).get(MoviesViewModel.class);
        recyclerView = view.findViewById(R.id.recyclerView);

        setAdapter(moviesViewModel.populate());

    }

    private void setAdapter(List<Movies> list) {
        MoviesAdapater adapter = new MoviesAdapater(list, new MoviesAdapater.OnItemClickListener() {
            @Override
            public void onItemClick(Movies model) {
                Intent intent = new Intent(getContext(), DetailMovieActivity.class);
                intent.putExtra(Movies.class.getName(), model);
                startActivity(intent);
            }
        }, false);

        final LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }



}
