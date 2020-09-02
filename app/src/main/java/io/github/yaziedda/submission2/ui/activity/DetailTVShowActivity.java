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
import io.github.yaziedda.submission2.model.TVShow;
import io.github.yaziedda.submission2.model.TVShowResult;
import io.github.yaziedda.submission2.util.Static;

public class DetailTVShowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tvshow);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView title = findViewById(R.id.tv_title);
        TextView desc = findViewById(R.id.tv_desc);
        TextView release = findViewById(R.id.tv_release);
        ImageView img = findViewById(R.id.img);

        TVShowResult item = (TVShowResult) getIntent().getSerializableExtra(TVShowResult.class.getName());

        if (item != null) {
            setTitle(item.getOriginalName());

            title.setText(item.getOriginalName());

            desc.setText(item.getOverview());
            release.setText(item.getFirstAirDate());

            Glide.with(getApplicationContext())
                    .load(Static.getUrlPoster(Static.POSTER_w780, item.getPosterPath()))
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(img);
        } else {

            TVShow tvShow = (TVShow) getIntent().getSerializableExtra(TVShow.class.getName());
            setTitle(tvShow.getTitle());

            title.setText(tvShow.getTitle());

            desc.setText(tvShow.getDescription());

            release.setText(tvShow.getRelease());

            Glide.with(getApplicationContext())
                    .load(Static.getUrlPoster(Static.POSTER_w780, tvShow.getImageUrl()))
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
