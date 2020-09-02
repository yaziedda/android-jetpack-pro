package io.github.yaziedda.submission2.ui.activity;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import io.github.yaziedda.submission2.R;
import io.github.yaziedda.submission2.model.Movies;
import io.github.yaziedda.submission2.model.MoviesResult;
import io.github.yaziedda.submission2.util.Static;

public class DetailMovieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView title = findViewById(R.id.tv_title);
        TextView desc = findViewById(R.id.tv_desc);
        TextView release = findViewById(R.id.tv_release);
        ImageView img = findViewById(R.id.img);


        MoviesResult item = (MoviesResult) getIntent().getSerializableExtra(MoviesResult.class.getName());

        if (item != null){
            setTitle(item.getTitle());

            title.setText(item.getTitle());

            desc.setText(item.getOverview());

            release.setText(item.getReleaseDate());

            Glide.with(getApplicationContext())
                    .load(Static.getUrlPoster(Static.POSTER_w780, item.getPosterPath()))
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(img);
        }else{
            Movies movies = (Movies) getIntent().getSerializableExtra(Movies.class.getName());
            setTitle(movies.getTitle());

            title.setText(movies.getTitle());

            desc.setText(movies.getDescription());

            release.setText(movies.getRelease());

            Glide.with(getApplicationContext())
                    .load(Static.getUrlPoster(Static.POSTER_w780, movies.getImageUrl()))
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(img);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
