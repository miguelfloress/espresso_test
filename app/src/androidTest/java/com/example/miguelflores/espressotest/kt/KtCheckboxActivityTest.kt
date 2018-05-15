package com.example.miguelflores.espressotest.kt

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.ViewInteraction
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.example.miguelflores.espressotest.R
import com.example.miguelflores.espressotest.activities.CheckboxActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * @author miguel.flores.
 */
@RunWith(AndroidJUnit4::class)
class KtCheckboxActivityTest {

    @get:Rule
    var mainActivityRule = ActivityTestRule<CheckboxActivity>(CheckboxActivity::class.java)
    private var checkbox: ViewInteraction? = null
    private var textViewSelection: ViewInteraction? = null

    @Before
    fun setUp() {
        checkbox = onView(ViewMatchers.withId(R.id.checkbox))
        textViewSelection = onView(withId(R.id.textView_label))
    }

    @Test
    fun checkInitialState() {
        checkbox!!.check(matches(withText(R.string.button_test_checkbox)))
        checkbox!!.check(matches(isNotChecked()))
        textViewSelection!!.check(matches(withText("")))
        textViewSelection!!.check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
    }

    @Test
    fun performCheckboxClick() {
        checkbox!!.perform(click())
        checkbox!!.check(matches(isChecked()))
        checkbox!!.check(matches(withText("checked")))
        textViewSelection!!.check(matches(withText("Checked and a short description at the bottom")))
    }

    @Test
    fun performCheckboxSelectionAndUselect() {
        checkbox!!.perform(click())
        checkbox!!.perform(click())
        checkbox!!.check(matches(isNotChecked()))
        checkbox!!.check(matches(withText("unchecked")))
        textViewSelection!!.check(matches(withText("Un-Checked and a short description at the bottom")))
    }
}
