package io.github.yaziedda.submission2.networking.repo;


import android.arch.lifecycle.MutableLiveData;

import io.github.yaziedda.submission2.model.ResponseTVShow;
import io.github.yaziedda.submission2.networking.ApiInterface;
import io.github.yaziedda.submission2.networking.RetrofitService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TVShowRepository {

    private static TVShowRepository repository;

    public static TVShowRepository getInstance(){
        if (repository == null){
            repository = new TVShowRepository();
        }
        return repository;
    }

    private ApiInterface apiInterface;

    public TVShowRepository(){
        apiInterface = RetrofitService.cteateService(ApiInterface.class);
    }

    public MutableLiveData<ResponseTVShow> getData(String key, String lang){
        final MutableLiveData<ResponseTVShow> newsData = new MutableLiveData<>();
        apiInterface.getTVShowList(key, lang).enqueue(new Callback<ResponseTVShow>() {
            @Override
            public void onResponse(Call<ResponseTVShow> call,
                                   Response<ResponseTVShow> response) {
                if (response.isSuccessful()){
                    newsData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<ResponseTVShow> call, Throwable t) {
                newsData.setValue(null);
            }
        });
        return newsData;
    }
}
