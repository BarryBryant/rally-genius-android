package com.b3sk.rallygenius;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.b3sk.rallygenius.Activities.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by Joopkins on 7/24/16.
 */

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<MainActivity>(
            MainActivity.class);

    public static RecyclerViewMatcher withRecyclerView(final int recyclerViewId) {
        return new RecyclerViewMatcher(recyclerViewId);
    }

    @Test
    public void shouldDisplayNumberOneOverFirstItemInRecyclerView() {
        onView(withRecyclerView(R.id.sign_list_recycler).atPosition(0))
                .check(matches(hasDescendant(withText("1"))));
    }

    @Test
    public void shouldDisplaySignOneContentOnClickSignOne() {
        onView(withId(R.id.sign_list_recycler)).perform(RecyclerViewActions.actionOnItemAtPosition(
        0, click()));
        onView(withText(R.string.sign1)).check(matches(isDisplayed()));
    }

}
