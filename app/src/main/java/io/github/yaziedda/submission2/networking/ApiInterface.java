package io.github.yaziedda.submission2.networking;

import io.github.yaziedda.submission2.model.ResponseMovies;
import io.github.yaziedda.submission2.model.ResponseTVShow;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("movie")
    Call<ResponseMovies> getMoviesList(@Query("api_key") String apiKey, @Query("language") String lang);

    @GET("tv")
    Call<ResponseTVShow> getTVShowList(@Query("api_key") String apiKey, @Query("language") String lang);
}
