package io.github.yaziedda.submission2.util;

import android.support.test.espresso.IdlingResource;
import android.support.test.espresso.idling.CountingIdlingResource;

/**
 * Created by yaziedda on 2020-01-04.
 */
public class EspressoIdlingResource {

    private static final String RESOURCE = "GLOBAL";
    private static CountingIdlingResource espressoTestIdlingResource = new CountingIdlingResource(RESOURCE);

    public static void increment() {
        espressoTestIdlingResource.increment();
    }

    public static void decrement() {
        espressoTestIdlingResource.decrement();
    }

    public static IdlingResource getEspressoIdlingResource() {
        return espressoTestIdlingResource;
    }

}
