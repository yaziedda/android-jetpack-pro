package io.github.yaziedda.submission2.ui.fragment;


import android.arch.lifecycle.ViewModelProviders;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.test.espresso.IdlingResource;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import io.github.yaziedda.submission2.R;
import io.github.yaziedda.submission2.adapter.MoviesMVVMAdapter;
import io.github.yaziedda.submission2.model.MoviesResult;
import io.github.yaziedda.submission2.ui.activity.DetailMovieActivity;
import io.github.yaziedda.submission2.util.EspressoIdlingResource;
import io.github.yaziedda.submission2.viewmodel.MoviesViewModels;

/**
 * A simple {@link Fragment} subclass.
 */
public class MoviesFragmentData extends Fragment {


    public MoviesFragmentData() {
        // Required empty public constructor
    }

    RecyclerView recyclerView;

    List<MoviesResult> list = new ArrayList<>();
    MoviesMVVMAdapter moviesMVVMAdapter;
    MoviesViewModels moviesViewModels;
    ProgressBar progressBar;

    private BroadcastReceiver myReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            String locale = Locale.getDefault().getCountry();
            Toast.makeText(context, "LOCALE CHANGED to " + locale,
                    Toast.LENGTH_LONG).show();
            loadData();
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movies, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recyclerView);
        progressBar = view.findViewById(R.id.progressBar);

        IntentFilter filter = new IntentFilter(Intent.ACTION_LOCALE_CHANGED);
        getActivity().registerReceiver(myReceiver, filter);
        loadData();
        setupRecyclerView();

    }

    private void loadData() {
        recyclerView.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);

        moviesViewModels = ViewModelProviders.of(this).get(MoviesViewModels.class);
        moviesViewModels.init();
        String locale = Locale.getDefault().getCountry();
        if (locale.equals("ID")) {
            EspressoIdlingResource.increment();
            moviesViewModels.getRepository("id-ID").observe(this, responseMovies -> {
                progressBar.setVisibility(View.GONE);
                recyclerView.setVisibility(View.VISIBLE);

                List<MoviesResult> moviesResultList = responseMovies.getResults();
                list.addAll(moviesResultList);
                moviesMVVMAdapter.notifyDataSetChanged();
                EspressoIdlingResource.decrement();
            });
        }else{
            EspressoIdlingResource.increment();
            moviesViewModels.getRepository("en-US").observe(this, responseMovies -> {
                progressBar.setVisibility(View.GONE);
                recyclerView.setVisibility(View.VISIBLE);

                List<MoviesResult> moviesResultList = responseMovies.getResults();
                list.addAll(moviesResultList);
                moviesMVVMAdapter.notifyDataSetChanged();
                EspressoIdlingResource.decrement();
            });
        }
    }

    private void setupRecyclerView() {
        if (moviesMVVMAdapter == null) {
            moviesMVVMAdapter = new MoviesMVVMAdapter(getContext(), list, model -> {
                Intent intent = new Intent(getContext(), DetailMovieActivity.class);
                intent.putExtra(MoviesResult.class.getName(), model);
                startActivity(intent);
            });
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            recyclerView.setAdapter(moviesMVVMAdapter);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setNestedScrollingEnabled(true);
        } else {
            moviesMVVMAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (myReceiver != null){
            getActivity().unregisterReceiver(myReceiver);
        }
    }




}
