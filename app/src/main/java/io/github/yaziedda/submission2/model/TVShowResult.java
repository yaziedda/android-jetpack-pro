package io.github.yaziedda.submission2.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaziedda on 2019-11-12.
 */
public class TVShowResult implements Serializable {

    @SerializedName("original_name")
    @Expose
    private String originalName;
    @SerializedName("genre_ids")
    @Expose
    private List<Integer> genreIds = null;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("popularity")
    @Expose
    private Double popularity;
    @SerializedName("origin_country")
    @Expose
    private List<String> originCountry = null;
    @SerializedName("vote_count")
    @Expose
    private Integer voteCount;
    @SerializedName("first_air_date")
    @Expose
    private String firstAirDate;
    @SerializedName("backdrop_path")
    @Expose
    private String backdropPath;
    @SerializedName("original_language")
    @Expose
    private String originalLanguage;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("vote_average")
    @Expose
    private Double voteAverage;
    @SerializedName("overview")
    @Expose
    private String overview;
    @SerializedName("poster_path")
    @Expose
    private String posterPath;

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public List<Integer> getGenreIds() {
        return genreIds;
    }

    public void setGenreIds(List<Integer> genreIds) {
        this.genreIds = genreIds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    public List<String> getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(List<String> originCountry) {
        this.originCountry = originCountry;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

    public String getFirstAirDate() {
        return firstAirDate;
    }

    public void setFirstAirDate(String firstAirDate) {
        this.firstAirDate = firstAirDate;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(Double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public static ResponseTVShow dummyResponse(){
        ResponseTVShow responseTVShow = new ResponseTVShow();
        responseTVShow.setPage(1);
        responseTVShow.setTotalPages(5);
        responseTVShow.setTotalResults(10);
        responseTVShow.setResults(populate());
        return responseTVShow;

    }

    public static List<TVShowResult> populate(){


        String[] title = {"Watchmen",
                "Daybreak",
                "Tom Clancys Jack Ryan",
                "The Mandalorian",
                "The Witcher",
                "The Walking Dead",
                "American Horror Story",
                "Peaky Blinders",
                "See",
                "The Kominsky Method",
                "BoJack Horseman"};
        String[] desc = {"Set in an alternate history where masked vigilantes are treated as outlaws, Watchmen embraces the nostalgia of the original groundbreaking graphic novel of the same name, while attempting to break new ground of its own.",
                "High school outcast Josh is searching for his missing girlfriend in post apocalyptic Glendale. Hes joined by a group of misfits Angelica and his former bully Wesley. On the way theyll face many weird things.",
                "An upandcoming CIA analyst, Jack Ryan, is thrust into a dangerous field assignment as he uncovers a pattern in terrorist communication that launches him into the center of a dangerous gambit.",
                "The travails of a lone gunfighter in the outer reaches of the galaxy, far from the authority of the New Republic.",
                "Geralt of Rivia, a solitary monster hunter, struggles to find his place in a world where people often prove more wicked than beasts.",
                "Sheriff Deputy Rick Grimes wakes up from a coma to learn the world is in ruins, and must lead a group of survivors to stay alive.",
                "An anthology series centering on different characters and locations, including a house with a murderous past, an insane asylum, a witch coven, a freak show circus, a haunted hotel, a possessed farmhouse, a cult, the apocalypse, and a slasher summer camp.",
                "A gangster family epic set in 1919 Birmingham, England; centered on a gang who sew razor blades in the peaks of their caps, and their fierce boss Tommy Shelby.",
                "Far in a dystopian future, the human race has lost the sense of sight, and society has had to find new ways to interact, build, hunt, and to survive. All of that is challenged when a set of twins is born with sight.",
                "An aging actor, who long ago enjoyed a brush with fame, makes his living as an acting coach.",
                "BoJack Horseman was the star of the hit television show Horsin Around in the 80s and 90s, now hes washed up, living in Hollywood, complaining about everything, and wearing colorful sweaters."};

        String[] release = {"2019",
                "2019",
                "2018",
                "2019",
                "2019",
                "2010",
                "2011",
                "2013",
                "2019",
                "2018",
                "2014"};
        String[] img = {"https://m.media-amazon.com/images/M/MV5BMDBkOWI2MzMtNGMxOC00MjI2LWFhZWUtMGFmNjc1M2Y0YmRhXkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_UX182_CR0,0,182,268_AL_.jpg",
                "https://m.media-amazon.com/images/M/MV5BM2MxNzI3MmItZmIzNC00NjYxLWIzMDEtMzdiNWFhYWVmYTU3XkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_UX182_CR0,0,182,268_AL_.jpg",
                "https://m.media-amazon.com/images/M/MV5BNDg1Zjc4YzktMmRmZi00ZWJmLWJiYzgtYjg3MmE0OTM1NzY5XkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_UY268_CR0,0,182,268_AL_.jpg",
                "https://m.media-amazon.com/images/M/MV5BMWI0OTJlYTItNzMwZi00YzRiLWJhMjItMWRlMDNhZjNiMzJkXkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_UX182_CR0,0,182,268_AL_.jpg",
                "https://m.media-amazon.com/images/M/MV5BYTQ0NzUyMTAtOTMzMS00ZDAwLWI1NjktYTVhN2Y0MzcwOGU5XkEyXkFqcGdeQXVyNjg2NjQwMDQ@._V1_UX182_CR0,0,182,268_AL_.jpg",
                "https://m.media-amazon.com/images/M/MV5BYWY4ODJiZjMtNWMxYi00ZmM5LWIwZmQtZWY0MjJmZGU5MjcxXkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_UX182_CR0,0,182,268_AL_.jpg",
                "https://m.media-amazon.com/images/M/MV5BODZlYzc2ODYtYmQyZS00ZTM4LTk4ZDQtMTMyZDdhMDgzZTU0XkEyXkFqcGdeQXVyMzQ2MDI5NjU@._V1_UX182_CR0,0,182,268_AL_.jpg",
                "https://m.media-amazon.com/images/M/MV5BMTkzNjEzMDEzMF5BMl5BanBnXkFtZTgwMDI0MjE4MjE@._V1_UX182_CR0,0,182,268_AL_.jpg",
                "https://m.media-amazon.com/images/M/MV5BYWI2ZmM5ZTgtOTgxYS00MTQ4LThkMjQtZjBlNGM3NjQ5YTI5XkEyXkFqcGdeQXVyMDM2NDM2MQ@@._V1_UX182_CR0,0,182,268_AL_.jpg",
                "https://m.media-amazon.com/images/M/MV5BMDg1NDNiNTUtOWQyMi00ZmFhLTg0YTEtNzgyYjBiMjhhOWE3XkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_UX182_CR0,0,182,268_AL_.jpg",
                "https://m.media-amazon.com/images/M/MV5BYWQwMDNkM2MtODU4OS00OTY3LTgwOTItNjE2Yzc0MzRkMDllXkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_UX182_CR0,0,182,268_AL_.jpg"};

        List<TVShowResult> list = new ArrayList<>();
        for (int i=0; i < title.length; i++){
            TVShowResult movies = new TVShowResult();
            movies.setId(i+1);
            movies.setName(title[i]);
            movies.setOverview(desc[i]);
            movies.setFirstAirDate(release[i]);
            movies.setPosterPath(img[i]);
            list.add(movies);
        }
        return list;
    }

}
