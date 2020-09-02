package io.github.yaziedda.submission2.ui.fragment;


import android.arch.lifecycle.ViewModelProviders;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
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
import io.github.yaziedda.submission2.adapter.TVShowMVVMAdapter;
import io.github.yaziedda.submission2.model.TVShowResult;
import io.github.yaziedda.submission2.ui.activity.DetailTVShowActivity;
import io.github.yaziedda.submission2.util.EspressoIdlingResource;
import io.github.yaziedda.submission2.viewmodel.TVShowViewModels;


/**
 * A simple {@link Fragment} subclass.
 */
public class TVShowFragmentData extends Fragment {


    public TVShowFragmentData() {
        // Required empty public constructor
    }

    RecyclerView recyclerView;

    List<TVShowResult> list = new ArrayList<>();
    TVShowMVVMAdapter tvShowMVVMAdapter;
    TVShowViewModels tvShowViewModels;
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
        return inflater.inflate(R.layout.fragment_tvshow, container, false);
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

        tvShowViewModels = ViewModelProviders.of(this).get(TVShowViewModels.class);
        tvShowViewModels.init();
        String locale = Locale.getDefault().getCountry();
        if (locale.equals("ID")) {
            EspressoIdlingResource.increment();
            tvShowViewModels.getRepository("id-ID").observe(this, responseMovies -> {
                progressBar.setVisibility(View.GONE);
                recyclerView.setVisibility(View.VISIBLE);

                List<TVShowResult> moviesResultList = responseMovies.getResults();
                list.addAll(moviesResultList);
                tvShowMVVMAdapter.notifyDataSetChanged();
                EspressoIdlingResource.decrement();
            });
        }else{
            EspressoIdlingResource.increment();
            tvShowViewModels.getRepository("en-US").observe(this, responseMovies -> {
                progressBar.setVisibility(View.GONE);
                recyclerView.setVisibility(View.VISIBLE);

                List<TVShowResult> moviesResultList = responseMovies.getResults();
                list.addAll(moviesResultList);
                tvShowMVVMAdapter.notifyDataSetChanged();
                EspressoIdlingResource.decrement();
            });
        }
    }

    private void setupRecyclerView() {
        if (tvShowMVVMAdapter == null) {
            tvShowMVVMAdapter = new TVShowMVVMAdapter(getContext(), list, model -> {
                Intent intent = new Intent(getContext(), DetailTVShowActivity.class);
                intent.putExtra(TVShowResult.class.getName(), model);
                startActivity(intent);
            });
            recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
            recyclerView.setAdapter(tvShowMVVMAdapter);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setNestedScrollingEnabled(true);
        } else {
            tvShowMVVMAdapter.notifyDataSetChanged();
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

