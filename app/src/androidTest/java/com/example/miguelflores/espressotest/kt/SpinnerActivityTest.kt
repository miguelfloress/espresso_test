package com.example.miguelflores.espressotest.activities

import android.support.test.espresso.Espresso.onData
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.ViewInteraction
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import com.example.miguelflores.espressotest.R
import com.example.miguelflores.espressotest.util.MyUtilValidator.getResourceString
import org.hamcrest.Matchers.*
import android.support.test.runner.AndroidJUnit4
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
/**
 * @author miguel.flores.
 */
@RunWith(AndroidJUnit4::class)
class SpinnerActivityTest {

    @get:Rule
    var mainActivityRule = ActivityTestRule(SpinnerActivity::class.java)
    private var spinner: ViewInteraction? = null
    private var textViewSelection: ViewInteraction? = null

    @Before
    fun setUp() {
        spinner = onView(withId(R.id.spinner))
        textViewSelection = onView(withId(R.id.textView_selection))
    }

    @Test
    fun checkInitialState() {
        spinner!!.check(matches(withSpinnerText(R.string.select_one)))
        textViewSelection!!.check(matches(withText(R.string.select_one)))
    }

    @Test
    fun testSpinnerSelections() {
        checkSpinnerSelectionForRes(R.string.item_1)
        checkSpinnerSelectionForRes(R.string.item_2)
        checkSpinnerSelectionForRes(R.string.item_3)
        checkSpinnerSelectionForRes(R.string.select_one)
    }

    private fun checkSpinnerSelectionForRes(stringId: Int) {
        spinner!!.perform(click())
        onData(allOf(`is`(instanceOf<Any>(String::class.java)), `is`(getResourceString(stringId)))).perform(click())
        spinner!!.check(matches(withSpinnerText(stringId)))
        textViewSelection!!.check(matches(withText(stringId)))
    }
}
