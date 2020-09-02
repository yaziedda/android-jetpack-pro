package io.github.yaziedda.submission2.ui.activity;

import android.content.Intent;
import android.provider.Settings;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import io.github.yaziedda.submission2.R;
import io.github.yaziedda.submission2.adapter.SectionPagerAdapter;
import io.github.yaziedda.submission2.ui.fragment.MoviesFragment;
import io.github.yaziedda.submission2.ui.fragment.MoviesFragmentData;
import io.github.yaziedda.submission2.ui.fragment.TVShowFragment;
import io.github.yaziedda.submission2.ui.fragment.TVShowFragmentData;


public class HomeActivity extends AppCompatActivity {

    TabLayout tab;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tab = findViewById(R.id.tab);
        viewPager = findViewById(R.id.viewPager);

        SectionPagerAdapter sectionPagerAdapter = new SectionPagerAdapter(getSupportFragmentManager());
        sectionPagerAdapter.addFragment(new MoviesFragmentData());
        sectionPagerAdapter.addFragment(new TVShowFragmentData());
        viewPager.setAdapter(sectionPagerAdapter);
        tab.setupWithViewPager(viewPager);

        tab.getTabAt(0).setText(getResources().getString(R.string.tab_1));
        tab.getTabAt(1).setText(getResources().getString(R.string.tab_2));
    }

}
