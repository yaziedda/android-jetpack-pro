package io.github.yaziedda.submission2.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaziedda on 2019-11-06.
 */
public class Movies implements Serializable {

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

    public static List<Movies> populate(){


        String[] title = {"Avengers: Infinity War (2018)",
                "Spider-Man: Into the Spider-Verse",
                "Bohemian Rhapsody",
                "Joker",
                "Terminator: Dark Fate",
                "Maleficent: Mistress of Evil",
                "One Piece: Stampede",
                "El Camino: A Breaking Bad Movie",
                "Good Boys",
                "Doctor Sleep",
                "Zombieland: Double Tap"};
        String[] desc = {"As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment the fate of Earth and existence itself has never been more uncertain.",
                "Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson Kingpin Fisk uses a super collider, others from across the Spider-Verse are transported to this dimension.",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock n roll band Queen in 1970. Hit songs become instant classics. When Mercurys increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet finding a way to keep the band together amid the success and excess.",
                "During the 1980s, a failed stand-up comedian is driven insane and turns to a life of crime and chaos in Gotham City while becoming an infamous psychopathic crime figure.",
                "More than two decades have passed since Sarah Connor prevented Judgment Day, changed the future, and re-wrote the fate of the human race. Dani Ramos is living a simple life in Mexico City with her brother and father when a highly advanced and deadly new Terminator a Rev-9 travels back through time to hunt and kill her. Danis survival depends on her joining forces with two warriors: Grace, an enhanced super-soldier from the future, and a battle-hardened Sarah Connor. As the Rev-9 ruthlessly destroys everything and everyone in its path on the hunt for Dani, the three are led to a T-800 from Sarah’s past that may be their last best hope.",
                "Maleficent and her goddaughter Aurora begin to question the complex family ties that bind them as they are pulled in different directions by impending nuptials, unexpected allies, and dark new forces at play.",
                "One Piece: Stampede is a stand-alone film that celebrates the animes 20th Anniversary and takes place outside the canon of the One Piece TV series. Monkey D. Luffy and his Straw Hat pirate crew are invited to a massive Pirate Festival that brings many of the most iconic characters from throughout the franchise to participate in competition with the Straw Hats to find Rogers treasure. It also pits the Straw Hats against a new enemy named Bullet, a former member of Rogers crew.",
                "In the wake of his dramatic escape from captivity, Jesse Pinkman must come to terms with his past in order to forge some kind of future.",
                "A group of young boys on the cusp of becoming teenagers embark on an epic quest to fix their broken drone before their parents get home.",
                "A traumatized, alcoholic Dan Torrance meets Abra, a kid who also has the ability to shine. He tries to protect her from the True Knot, a cult whose goal is to feed off people like them in order to remain immortal.\n",
                "Columbus, Tallahassee, Wichita, and Little Rock move to the American heartland as they face off against evolved zombies, fellow survivors, and the growing pains of the snarky makeshift family."};

        String[] release = {"April 27, 2018",
                "December 14, 2018",
                "December 14, 2018",
                "October 4, 2019",
                "November 1, 2019",
                "October 18, 2019",
                "October 18, 2019",
                "October 11, 2019",
                "August 16, 2019",
                "November 8, 2019",
                "November 8, 2019"};
        String[] img = {"https://image.tmdb.org/t/p/w370_and_h556_bestv2/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg",
                "https://image.tmdb.org/t/p/w370_and_h556_bestv2/iiZZdoQBEYBv6id8su7ImL0oCbD.jpg",
                "https://image.tmdb.org/t/p/w370_and_h556_bestv2/lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg",
                "https://image.tmdb.org/t/p/w370_and_h556_bestv2/udDclJoHjfjb8Ekgsd4FDteOkCU.jpg",
                "https://image.tmdb.org/t/p/w370_and_h556_bestv2/vqzNJRH4YyquRiWxCCOH0aXggHI.jpg",
                "https://image.tmdb.org/t/p/w370_and_h556_bestv2/tBuabjEqxzoUBHfbyNbd8ulgy5j.jpg",
                "https://image.tmdb.org/t/p/w370_and_h556_bestv2/4E2lyUGLEr3yH4q6kJxPkQUhX7n.jpg",
                "https://image.tmdb.org/t/p/w370_and_h556_bestv2/ePXuKdXZuJx8hHMNr2yM4jY2L7Z.jpg",
                "https://image.tmdb.org/t/p/w370_and_h556_bestv2/tximyCXMEnWIIyOy9STkOduUprG.jpg",
                "https://image.tmdb.org/t/p/w370_and_h556_bestv2/p69QzIBbN06aTYqRRiCOY1emNBh.jpg",
                "https://image.tmdb.org/t/p/w370_and_h556_bestv2/pIcV8XXIIvJCbtPoxF9qHMKdRr2.jpg"};

        List<Movies> list = new ArrayList<>();
        for (int i=0; i < title.length; i++){
            Movies movies = new Movies();
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
