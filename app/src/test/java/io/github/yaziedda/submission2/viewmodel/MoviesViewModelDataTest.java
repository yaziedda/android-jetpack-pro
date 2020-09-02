package io.github.yaziedda.submission2.viewmodel;

import android.app.Instrumentation;
import android.arch.core.executor.testing.InstantTaskExecutorRule;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.List;

import io.github.yaziedda.submission2.model.Movies;
import io.github.yaziedda.submission2.model.MoviesResult;
import io.github.yaziedda.submission2.model.ResponseMovies;
import io.github.yaziedda.submission2.model.ResponseTVShow;
import io.github.yaziedda.submission2.model.TVShowResult;
import io.github.yaziedda.submission2.networking.repo.MoviesRepository;
import io.github.yaziedda.submission2.networking.repo.TVShowRepository;
import io.github.yaziedda.submission2.util.Static;
import io.reactivex.Single;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by yaziedda on 2019-11-27.
 */
public class MoviesViewModelDataTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();
    @Mock
    private MoviesViewModels viewModel;
    @Mock
    private TVShowViewModels tvShowViewModels;
    @Mock
    private MoviesRepository remote;
    @Mock
    private TVShowRepository remoteTvShow;
    @Mock
    Observer<ResponseMovies> observer;
    @Mock
    Observer<ResponseTVShow> tvShowObserver;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        viewModel = new MoviesViewModels();
        viewModel.init();
        viewModel.getRepository("en-US").observeForever(observer);

        tvShowViewModels = new TVShowViewModels();
        tvShowViewModels.init();
        tvShowViewModels.getRepository("en-US").observeForever(tvShowObserver);


    }

    @Test
    public void testNull() {
        when(remote.getData(Static.API_KEY, "en-US")).thenReturn(null);
        assertNotNull(viewModel.getRepository("en-US"));

        when(remoteTvShow.getData(Static.API_KEY, "en-US")).thenReturn(null);
        assertNotNull(tvShowViewModels.getRepository("en-US"));
    }

    @Test
    public void testApiFetchDataSuccess() {
        // Movie
        ResponseMovies responseMovies = MoviesResult.dummyResponse();

        MutableLiveData<ResponseMovies> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue(responseMovies);

        when(remote.getData(Static.API_KEY, "en-US")).thenReturn(mutableLiveData);

        // TV Show
        ResponseTVShow responseTVShow = TVShowResult.dummyResponse();

        MutableLiveData<ResponseTVShow> responseTVShowMutableLiveData = new MutableLiveData<>();
        responseTVShowMutableLiveData.setValue(responseTVShow);

        when(remoteTvShow.getData(Static.API_KEY, "en-US")).thenReturn(responseTVShowMutableLiveData);
    }


}