package io.github.yaziedda.submission2.ui.fragment;


import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import io.github.yaziedda.submission2.R;
import io.github.yaziedda.submission2.adapter.TVShowAdapater;
import io.github.yaziedda.submission2.model.Movies;
import io.github.yaziedda.submission2.model.TVShow;
import io.github.yaziedda.submission2.ui.activity.DetailMovieActivity;
import io.github.yaziedda.submission2.ui.activity.DetailTVShowActivity;
import io.github.yaziedda.submission2.viewmodel.MoviesViewModel;
import io.github.yaziedda.submission2.viewmodel.TVShowViewModel;


/**
 * A simple {@link Fragment} subclass.
 */
public class TVShowFragment extends Fragment {


    public TVShowFragment() {
        // Required empty public constructor
    }

    RecyclerView recyclerView;
    TVShowViewModel tvShowViewModel;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tvshow, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvShowViewModel = ViewModelProviders.of(this).get(TVShowViewModel.class);
        recyclerView = view.findViewById(R.id.recyclerView);
        setAdapter(tvShowViewModel.populate());
    }

    private void setAdapter(List<TVShow> list) {

        TVShowAdapater adapter = new TVShowAdapater(list, new TVShowAdapater.OnItemClickListener() {
            @Override
            public void onItemClick(TVShow model) {
                Intent intent = new Intent(getContext(), DetailTVShowActivity.class);
                intent.putExtra(TVShow.class.getName(), model);
                startActivity(intent);
            }
        }, false);

        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerView.setAdapter(adapter);
    }

}

