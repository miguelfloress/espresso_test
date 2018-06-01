package com.example.miguelflores.espressotest.activities;

import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.miguelflores.espressotest.R;
import com.example.miguelflores.espressotest.activities.SpinnerActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withSpinnerText;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.example.miguelflores.espressotest.util.MyUtilValidator.getResourceString;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

/**
 * @author miguel.flores.
 */
@RunWith(AndroidJUnit4.class)
public class SpinnerTestActivity {

    @Rule
    public ActivityTestRule<SpinnerActivity> mainActivityRule = new ActivityTestRule<>(SpinnerActivity.class);
    private ViewInteraction spinner;
    private ViewInteraction textViewSelection;

    @Before
    public void setUp() {
        spinner = onView(withId(R.id.spinner));
        textViewSelection = onView(withId(R.id.textView_selection));
    }

    @Test
    public void checkInitialState() {
        spinner.check(matches(withSpinnerText(R.string.select_one)));
        textViewSelection.check(matches(withText(R.string.select_one)));
    }

    @Test
    public void testSpinnerSelections() {
        checkSpinnerSelectionForRes(R.string.item_1);
        checkSpinnerSelectionForRes(R.string.item_2);
        checkSpinnerSelectionForRes(R.string.item_3);
        checkSpinnerSelectionForRes(R.string.select_one);
    }

    private void checkSpinnerSelectionForRes(int stringId) {
        spinner.perform(click());
        onData(allOf(is(instanceOf(String.class)), is(getResourceString(stringId)))).perform(click());
        spinner.check(matches(withSpinnerText(stringId)));
        textViewSelection.check(matches(withText(stringId)));
    }
}
