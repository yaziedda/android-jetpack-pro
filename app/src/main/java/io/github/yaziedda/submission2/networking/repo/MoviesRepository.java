package io.github.yaziedda.submission2.networking.repo;


import android.arch.lifecycle.MutableLiveData;

import io.github.yaziedda.submission2.model.ResponseMovies;
import io.github.yaziedda.submission2.networking.ApiInterface;
import io.github.yaziedda.submission2.networking.RetrofitService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MoviesRepository {

    private static MoviesRepository repository;

    public static MoviesRepository getInstance(){
        if (repository == null){
            repository = new MoviesRepository();
        }
        return repository;
    }

    private ApiInterface apiInterface;

    public MoviesRepository(){
        apiInterface = RetrofitService.cteateService(ApiInterface.class);
    }

    public MutableLiveData<ResponseMovies> getData(String key, String lang){
        final MutableLiveData<ResponseMovies> newsData = new MutableLiveData<>();
        apiInterface.getMoviesList(key, lang).enqueue(new Callback<ResponseMovies>() {
            @Override
            public void onResponse(Call<ResponseMovies> call,
                                   Response<ResponseMovies> response) {
                if (response.isSuccessful()){
                    newsData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<ResponseMovies> call, Throwable t) {
                newsData.setValue(null);
            }
        });
        return newsData;
    }
}
