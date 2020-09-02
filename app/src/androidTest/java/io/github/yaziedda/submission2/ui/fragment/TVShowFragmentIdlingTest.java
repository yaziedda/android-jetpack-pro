package io.github.yaziedda.submission2.ui.fragment;

import android.support.test.espresso.IdlingRegistry;
import android.support.test.espresso.action.ViewActions;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import id.github.yaziedda.submission2.testing.SingleFragmentActivity;
import io.github.yaziedda.submission2.R;
import io.github.yaziedda.submission2.util.EspressoIdlingResource;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static io.github.yaziedda.submission2.ui.fragment.TestUtils.withRecyclerView;

/**
 * Created by yaziedda on 2019-11-27.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class TVShowFragmentIdlingTest {

    @Rule
    public ActivityTestRule<SingleFragmentActivity> activityRule = new ActivityTestRule<>(SingleFragmentActivity.class);
    private TVShowFragmentData fragment = new TVShowFragmentData();

    @Before
    public void setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource());
        activityRule.getActivity().setFragment(fragment);
    }

    @After
    public void tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getEspressoIdlingResource());
    }

    @Test
    public void loadData() {
        onView(withId(R.id.recyclerView)).check(matches(isDisplayed()));

        onView(withRecyclerView(R.id.recyclerView).atPositionOnView(0, R.id.tv_title)).check(matches(isDisplayed()));
        onView(withRecyclerView(R.id.recyclerView).atPositionOnView(0, R.id.tv_desc)).check(matches(isDisplayed()));
        onView(withRecyclerView(R.id.recyclerView).atPositionOnView(0, R.id.tv_release)).check(matches(isDisplayed()));

        onView(withRecyclerView(R.id.recyclerView).atPosition(0)).perform(ViewActions.click());

        onView(withId(R.id.tv_title)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_desc)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_release)).check(matches(isDisplayed()));


    }

}