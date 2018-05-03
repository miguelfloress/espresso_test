package com.example.miguelflores.espressotest;

import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.miguelflores.espressotest.activities.ButtonActivity;
import com.example.miguelflores.espressotest.base.BaseTest;
import com.example.miguelflores.espressotest.util.MyUtilValidator;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasTextColor;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


/**
 * @author miguel.flores.
 */

@RunWith(AndroidJUnit4.class)
public class ButtonActivityTest extends BaseTest {

    @Rule
    public ActivityTestRule<ButtonActivity> mainActivityRule = new ActivityTestRule<ButtonActivity>(ButtonActivity.class);

    private ViewInteraction button;
    private ViewInteraction textView;

    @Before
    public void setUp() {
        button = onView(withId(R.id.button));
        textView = onView(withId(R.id.textViewCounter));
    }

    @Test
    public void checkInitialState() {
        button.check(matches(withText(R.string.button_text)));
        button.check(matches(isEnabled()));
        button.check(matches(hasTextColor(R.color.colorAccent)));
        textView.check(matches((withEffectiveVisibility(ViewMatchers.Visibility.GONE))));
    }

    @Test
    public void checkButtonClickedCounter() {
        button.perform(click());
        textView.check(matches(withText(MyUtilValidator.getResourceString(R.string.clicked, "1"))));
        textView.check(matches((withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE))));
    }

    @Test
    public void checkButtonClickedSeveralTimesCounter() {
        for (int i = 0; i < 10; i++) {
            button.perform(click());
        }
        textView.check(matches(withText(MyUtilValidator.getResourceString(R.string.clicked, "10"))));
        textView.check(matches((withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE))));
    }
}
