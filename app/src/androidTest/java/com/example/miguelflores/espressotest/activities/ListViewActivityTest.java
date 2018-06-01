package com.example.miguelflores.espressotest.activities;

import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.miguelflores.espressotest.R;
import com.example.miguelflores.espressotest.activities.ListViewActivity;
import com.example.miguelflores.espressotest.base.BaseTest;
import com.example.miguelflores.espressotest.util.MyUtilValidator;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.example.miguelflores.espressotest.util.ListSizeMatcher.hasListSize;

/**
 * @author miguel.flores.
 */
@RunWith(AndroidJUnit4.class)
public class ListViewActivityTest extends BaseTest {

    @Rule
    public ActivityTestRule<ListViewActivity> mainActivityRule = new ActivityTestRule<>(ListViewActivity.class);
    private ViewInteraction listView;
    private ViewInteraction textViewSelection;

    @Before
    public void setUp() {
        listView = onView(ViewMatchers.withId(R.id.listView));
        textViewSelection = onView(withId(R.id.textView_selection));
    }

    @Test
    public void checkInitialState() {
        listView.check(matches(hasListSize(20)));
        textViewSelection.check(matches(withText("")));
    }

    @Test
    public void clickOnItem() {
        listView.perform(click());
        checkTextSelection("List item 1");
        checkTextSelection("List item 5");
        checkTextSelection("List item 15");
    }

    private void checkTextSelection(String text) {
        MyUtilValidator.getDataInteraction(String.class, text).perform(click());
        textViewSelection.check(matches(withText(text)));
    }
}
