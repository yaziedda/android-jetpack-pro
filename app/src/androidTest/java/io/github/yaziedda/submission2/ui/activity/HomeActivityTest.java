package io.github.yaziedda.submission2.ui.activity;

import android.content.Intent;
import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import io.github.yaziedda.submission2.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by yaziedda on 2019-11-28.
 */
public class HomeActivityTest {


    @Rule
    public ActivityTestRule<HomeActivity> homeActivityActivityTestRule = new ActivityTestRule<HomeActivity>(HomeActivity.class){
        @Override
        protected Intent getActivityIntent() {
            return super.getActivityIntent();
        }
    };

    @Test
    public void checkUI(){
        onView(withId(R.id.viewPager)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.tab)).check(matches(isCompletelyDisplayed()));
    }

}