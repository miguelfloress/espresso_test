package com.example.miguelflores.espressotest;

import android.support.test.espresso.IdlingRegistry;
import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.miguelflores.espressotest.activities.IdlingResourcesActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * @author miguel.flores.
 */
@RunWith(AndroidJUnit4.class)
public class IdlingResourcesActivityTest {

    @Rule
    public ActivityTestRule<IdlingResourcesActivity> mainActivityRule = new ActivityTestRule<>(IdlingResourcesActivity.class);
    private ViewInteraction texView;
    private ViewInteraction buttonOne;
    private ViewInteraction buttonTwo;

    @Before
    public void setUp() {
        texView = onView(withId(R.id.textView_result));
        buttonOne = onView(withId(R.id.buttonOne));
        buttonTwo = onView(withId(R.id.buttonTwo));
    }

    @Test
    public void checkInitialState() {
        texView.check(matches(withText("")));
    }

    @Test
    public void onButtonOneClicked() {
        buttonOne.perform(click());
        texView.check(matches(withText(R.string.async_task_completed)));
    }

    @Test
    public void onButtonTwoClicked() {
        IdlingRegistry.getInstance().register(mainActivityRule.getActivity().getCountingIdlingResource());
        buttonTwo.perform(click());
        texView.check(matches(withText(R.string.thread_completed)));
    }
}
