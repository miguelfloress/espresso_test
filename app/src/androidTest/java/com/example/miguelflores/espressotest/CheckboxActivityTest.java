package com.example.miguelflores.espressotest;

import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.miguelflores.espressotest.activities.CheckboxActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.Visibility;
import static android.support.test.espresso.matcher.ViewMatchers.isChecked;
import static android.support.test.espresso.matcher.ViewMatchers.isNotChecked;
import static android.support.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * @author miguel.flores.
 */
@RunWith(AndroidJUnit4.class)
public class CheckboxActivityTest {

    @Rule
    public ActivityTestRule<CheckboxActivity> mainActivityRule = new ActivityTestRule<>(CheckboxActivity.class);
    private ViewInteraction checkbox;
    private ViewInteraction textViewSelection;

    @Before
    public void setUp() {
        checkbox = onView(withId(R.id.checkbox));
        textViewSelection = onView(withId(R.id.textView_label));
    }

    @Test
    public void checkInitialState() {
        checkbox.check(matches(withText(R.string.button_test_checkbox)));
        checkbox.check(matches(isNotChecked()));
        textViewSelection.check(matches(withText("")));
        textViewSelection.check(matches(withEffectiveVisibility(Visibility.VISIBLE)));
    }

    @Test
    public void performCheckboxClick() {
        checkbox.perform(click());
        checkbox.check(matches(isChecked()));
        checkbox.check(matches(withText("checked")));
        textViewSelection.check(matches(withText("Checked and a short description at the bottom")));
    }

    @Test
    public void performCheckboxSelectionAndUselect() {
        checkbox.perform(click());
        checkbox.perform(click());
        checkbox.check(matches(isNotChecked()));
        checkbox.check(matches(withText("unchecked")));
        textViewSelection.check(matches(withText("Un-Checked and a short description at the bottom")));
    }
}
