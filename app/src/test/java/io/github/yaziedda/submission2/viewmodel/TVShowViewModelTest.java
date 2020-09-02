package io.github.yaziedda.submission2.viewmodel;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import io.github.yaziedda.submission2.model.Movies;
import io.github.yaziedda.submission2.model.TVShow;

import static org.junit.Assert.*;

public class TVShowViewModelTest {

    private TVShowViewModel viewModel;

    @Before
    public void setUp() {
        viewModel = new TVShowViewModel();
    }

    @Test
    public void getTvShow() {
        TVShow movies = viewModel.getTvShow("11");
        assertNotNull(movies);
        assertNotNull(viewModel.getTvShow("11"));
    }

    @Test
    public void populate() {
        List<TVShow> courseEntities = viewModel.populate();
        assertNotNull(courseEntities);
        assertNotNull(viewModel.getTvShow("11"));
        assertEquals(11, courseEntities.size());
    }
}