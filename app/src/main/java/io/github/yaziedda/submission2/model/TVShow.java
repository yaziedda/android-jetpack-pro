package io.github.yaziedda.submission2.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaziedda on 2019-11-06.
 */
public class TVShow implements Serializable {

    private int id;
    private String title;
    private String description;
    private String release;
    private String imageUrl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public static List<TVShow> populate(){


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

        List<TVShow> list = new ArrayList<>();
        for (int i=0; i < title.length; i++){
            TVShow movies = new TVShow();
            movies.setId(i+1);
            movies.setTitle(title[i]);
            movies.setDescription(desc[i]);
            movies.setRelease(release[i]);
            movies.setImageUrl(img[i]);
            list.add(movies);
        }
        return list;
    }

}
