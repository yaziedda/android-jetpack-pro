package io.github.yaziedda.submission2.viewmodel;

import android.arch.lifecycle.ViewModel;

import java.util.List;

import io.github.yaziedda.submission2.model.Movies;
import io.github.yaziedda.submission2.model.TVShow;

/**
 * Created by yaziedda on 2019-11-27.
 */
public class TVShowViewModel extends ViewModel {

    TVShow tvShow = new TVShow();

    public TVShow getTvShow(String idMovies){
        for (TVShow m:
                tvShow.populate()) {
            if (String.valueOf(m.getId()).equals(idMovies)){
                return m;
            }
        }
        return null;
    }

    public List<TVShow> populate() {
        return tvShow.populate();
    }


}
