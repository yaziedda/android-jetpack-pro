package io.github.yaziedda.submission2.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import io.github.yaziedda.submission2.R;
import io.github.yaziedda.submission2.model.Movies;

/**
 * Created by yaziedda on 2019-11-27.
 */
public class MoviesViewModel extends ViewModel {

    Movies movies = new Movies();

    public Movies getMovieById(String idMovies){
        for (Movies m:
             movies.populate()) {
            if (String.valueOf(m.getId()).equals(idMovies)){
                return m;
            }
        }
        return null;
    }

    public List<Movies> populate() {
        return movies.populate();
    }


}
