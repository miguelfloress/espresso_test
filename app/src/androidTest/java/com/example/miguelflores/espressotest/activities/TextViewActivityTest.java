package com.example.miguelflores.espressotest.activities;

import android.support.test.espresso.matcher.BoundedMatcher;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;

import com.example.miguelflores.espressotest.R;
import com.example.miguelflores.espressotest.base.BaseTest;
import com.example.miguelflores.espressotest.custom.MyCustomView;

import org.hamcrest.Description;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;

/**
 * @author miguel.flores.
 */
@RunWith(AndroidJUnit4.class)
public class TextViewActivityTest extends BaseTest {

    @Rule
    public ActivityTestRule<TextViewActivity> mainActivityRule = new ActivityTestRule<TextViewActivity>(TextViewActivity.class);

    /**
     * check all the views that must be visible are visible clickeables etc.
     */
    @Test
    public void checkInitialState() {
        onView(withId(R.id.textViewTitle)).check(matches(isDisplayed()));
        onView(withId(R.id.textViewHideSubtitle1)).check(matches((withEffectiveVisibility(ViewMatchers.Visibility.GONE))));
        onView(withId(R.id.textViewHideSubtitle2)).check(matches((withEffectiveVisibility(ViewMatchers.Visibility.INVISIBLE))));
    }

    @Test
    public void checkSubtitleOneShowAfterClick() {
        sleepPresentation(1000);
        onView(withId(R.id.textViewTitle)).perform(click());
        sleepPresentation(1000);
        onView(withId(R.id.textViewHideSubtitle1)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        sleepPresentation(1000);
    }

    @Test
    public void checkSubtitleOneShowAfterSecondClick() {
        checkSubtitleOneShowAfterClick();
        onView(withId(R.id.textViewTitle)).perform(click());
        sleepPresentation(1000);
        onView(withId(R.id.textViewHideSubtitle1)).check(matches(not(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE))));
        sleepPresentation(1000);
    }

    /**
     * check textviews texts when init view
     */
    @Test
    public void checkViewCorrectTexts() {
        onView(withId(R.id.textViewTitle)).check(matches(withText(R.string.title_text_view_example)));
        onView(withId(R.id.textViewHideSubtitle1)).check(matches(withText(R.string.title_subtitle_1)));
        onView(withId(R.id.textViewHideSubtitle2)).check(matches(withText(R.string.title_subtitle_2)));
    }


    /*@Test
    public void checkMyCustomView() {
        onView(withId(R.id.myCustomView)).check(matches(new MyCustomMatcher("12345")));
    }*/

}
