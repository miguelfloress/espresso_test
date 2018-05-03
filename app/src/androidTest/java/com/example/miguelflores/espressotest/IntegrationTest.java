package com.example.miguelflores.espressotest;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.miguelflores.espressotest.base.BaseTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by miguel.flores.
 */
@RunWith(AndroidJUnit4.class)
public class IntegrationTest extends BaseTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    /**
     * simple test to check button or view has the correct text
     */
    @Test
    public void checkMainViewButtons() {
        onView(withId(R.id.buttonTextView)).check(matches(withText(R.string.button_test_text_view)));
    }


    /**
     * validate when we tap on button a view from the TextViewActivity is show
     */
    @Test
    public void tapOnTextViewButton() {
        sleepPresentation(1000);
        onView(withId(R.id.buttonTextView)).perform(click());
        sleepPresentation(1000);
        onView(withId(R.id.textViewTitle)).check(matches(isDisplayed()));
        sleepPresentation(1000);
    }

}
