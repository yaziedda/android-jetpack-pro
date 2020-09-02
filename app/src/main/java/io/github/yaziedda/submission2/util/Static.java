package io.github.yaziedda.submission2.util;

/**
 * Created by yaziedda on 2019-11-11.
 */
public class Static {
    public static final String HOST = "https://api.themoviedb.org/3/discover/";
    public static final String API_KEY = "7b12624313469a963dfa28cedec6e6b6";
    public static final String getUrlPoster(String type, String name) {
        return "https://image.tmdb.org/t/p/" + type + "/" + name;
    }
    public static final String POSTER_w92 = "w92";
    public static final String POSTER_w154 = "w154";
    public static final String POSTER_w185 = "w185";
    public static final String POSTER_w342 = "w342";
    public static final String POSTER_w500 = "w500";
    public static final String POSTER_w780 = "w780";
    public static final String POSTER_original = "original";
}
