package io.github.yaziedda.submission2.viewmodel;

import android.app.Instrumentation;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import io.github.yaziedda.submission2.model.Movies;

import static org.junit.Assert.*;

/**
 * Created by yaziedda on 2019-11-27.
 */
public class MoviesViewModelTest extends Instrumentation {

    private MoviesViewModel viewModel;

    @Before
    public void setUp() {
        viewModel = new MoviesViewModel();
    }

    @Test
    public void getCourses() {
        List<Movies> courseEntities = viewModel.populate();
        assertNotNull(courseEntities);
        assertNotNull(viewModel.getMovieById("11"));
        assertEquals(11, courseEntities.size());
    }

    @Test
    public void getMovieById() {
        Movies movies = viewModel.getMovieById("11");
        assertNotNull(movies);
        assertNotNull(viewModel.getMovieById("11"));
    }

    @Test
    public void populate() {
        List<Movies> courseEntities = viewModel.populate();
        assertNotNull(courseEntities);
        assertNotNull(viewModel.getMovieById("11"));
        assertEquals(11, courseEntities.size());
    }
}