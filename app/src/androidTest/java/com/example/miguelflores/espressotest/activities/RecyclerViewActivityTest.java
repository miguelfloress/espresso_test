package com.example.miguelflores.espressotest.activities;

import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.miguelflores.espressotest.R;
import com.example.miguelflores.espressotest.base.BaseTest;
import com.example.miguelflores.espressotest.util.ListSizeMatcher;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.example.miguelflores.espressotest.util.MyViewAction.performClickOnChildWithId;

/**
 * @author miguel.flores.
 */
@RunWith(AndroidJUnit4.class)
public class RecyclerViewActivityTest extends BaseTest {

    @Rule
    public ActivityTestRule<RecyclerViewActivity> mainActivityRule = new ActivityTestRule<>(RecyclerViewActivity.class);
    private ViewInteraction recyclerView;
    private ViewInteraction textViewSelection;

    @Before
    public void setUp() {
        recyclerView = onView(withId(R.id.recyclerView));
        textViewSelection = onView(withId(R.id.textView_selection));
    }

    @Test
    public void checkInitialState() {
        recyclerView.check(matches(ListSizeMatcher.hasListSize(20)));
        textViewSelection.check(matches(withText("")));
    }

    @Test
    public void checkItemsClicked() {
        recyclerView.perform(click());
        checkRecyclerViewSelection(19, "Recycler Item Number 19");
        checkRecyclerViewSelection(1, "Recycler Item Number 1");
        checkRecyclerViewSelection(5, "Recycler Item Number 5");
        checkRecyclerViewSelection(17, "Recycler Item Number 17");
    }

    private void checkRecyclerViewSelection(int pos, String value) {
        recyclerView.perform(RecyclerViewActions.actionOnItemAtPosition(pos, performClickOnChildWithId(R.id.textView)));

        // uncomment this to show what happens
        //recyclerView.perform(RecyclerViewActions.actionOnItemAtPosition(pos,click()));

        textViewSelection.check(matches(withText(value)));
    }
}
