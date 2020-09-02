package io.github.yaziedda.submission2.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import io.github.yaziedda.submission2.R;
import io.github.yaziedda.submission2.model.TVShow;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by yaziedda on 2019-11-27.
 */
public class DetailTVShowActivityTest {

    private TVShow model = TVShow.populate().get(0);

    @Rule
    public ActivityTestRule<DetailTVShowActivity> activityRule = new ActivityTestRule<DetailTVShowActivity>(DetailTVShowActivity.class) {
        @Override
        protected Intent getActivityIntent() {
            Context targetContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
            Intent result = new Intent(targetContext, DetailTVShowActivity.class);
            result.putExtra(TVShow.class.getName(), model);
            return result;
        }
    };

    @Test
    public void loadData(){
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_title)).check(matches(withText(model.getTitle())));

        onView(withId(R.id.tv_desc)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_desc)).check(matches(withText(model.getDescription())));

        onView(withId(R.id.tv_release)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_release)).check(matches(withText(model.getRelease())));

        onView(withId(R.id.img)).check(matches(isDisplayed()));

    }

}