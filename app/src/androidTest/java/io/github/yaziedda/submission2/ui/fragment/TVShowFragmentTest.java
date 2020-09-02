package io.github.yaziedda.submission2.ui.fragment;

import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import id.github.yaziedda.submission2.testing.SingleFragmentActivity;
import io.github.yaziedda.submission2.R;
import io.github.yaziedda.submission2.model.TVShow;
import io.github.yaziedda.submission2.utils.RecyclerViewItemCountAssertion;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static io.github.yaziedda.submission2.ui.fragment.TestUtils.withRecyclerView;

/**
 * Created by yaziedda on 2019-11-27.
 */
public class TVShowFragmentTest {

    private TVShow model = TVShow.populate().get(0);

    @Rule
    public ActivityTestRule<SingleFragmentActivity> activityRule = new ActivityTestRule<>(SingleFragmentActivity.class);
    private TVShowFragment fragment = new TVShowFragment();

    @Before
    public void setUp() {
        activityRule.getActivity().setFragment(fragment);
    }

    @Test
    public void loadData() {
        onView(withId(R.id.recyclerView)).check(matches(isDisplayed()));
        onView(withId(R.id.recyclerView)).check(new RecyclerViewItemCountAssertion(11));

        onView(withRecyclerView(R.id.recyclerView).atPositionOnView(0, R.id.tv_title)).check(matches(withText(model.getTitle())));
        onView(withRecyclerView(R.id.recyclerView).atPositionOnView(0, R.id.tv_desc)).check(matches(withText(model.getDescription())));
        onView(withRecyclerView(R.id.recyclerView).atPositionOnView(0, R.id.tv_release)).check(matches(withText(model.getRelease())));

        onView(withRecyclerView(R.id.recyclerView).atPosition(0)).perform(ViewActions.click());

        onView(withId(R.id.tv_title)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_title)).check(matches(withText(model.getTitle())));

        onView(withId(R.id.tv_desc)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_desc)).check(matches(withText(model.getDescription())));

        onView(withId(R.id.tv_release)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_release)).check(matches(withText(model.getRelease())));
    }

}