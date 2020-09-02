package io.github.yaziedda.submission2.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import io.github.yaziedda.submission2.model.ResponseMovies;
import io.github.yaziedda.submission2.networking.repo.MoviesRepository;
import io.github.yaziedda.submission2.util.Static;

/**
 * Created by yaziedda on 2019-11-11.
 */
public class MoviesViewModels extends ViewModel {

    private MutableLiveData<ResponseMovies> mutableLiveData;
    private MoviesRepository repository;

    public void init(){
        if (mutableLiveData != null){
            return;
        }
        repository = MoviesRepository.getInstance();

    }

    public LiveData<ResponseMovies> getRepository(String lang) {
        return repository.getData(Static.API_KEY, lang);
    }

}
