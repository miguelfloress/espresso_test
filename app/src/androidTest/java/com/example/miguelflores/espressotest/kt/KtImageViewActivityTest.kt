package com.example.miguelflores.espressotest.kt

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.ViewInteraction
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.example.miguelflores.espressotest.R
import com.example.miguelflores.espressotest.activities.ImageViewActivity
import com.example.miguelflores.espressotest.util.DrawableMatcher
import com.example.miguelflores.espressotest.util.DrawableMatcher.withDrawable
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * @author miguel.flores.
 */
@RunWith(AndroidJUnit4::class)
class ImageViewActivityTest {

    @get:Rule
    var mainActivityRule = ActivityTestRule(ImageViewActivity::class.java)
    private var imageView: ViewInteraction? = null
    private var buttonIconOne: ViewInteraction? = null
    private var buttonIconTwo: ViewInteraction? = null

    @Before
    fun setUp() {
        imageView = onView(withId(R.id.imageView))
        buttonIconOne = onView(withId(R.id.buttonIconOne))
        buttonIconTwo = onView(withId(R.id.buttonIconTwo))
    }

    @Test
    fun checkInitialState() {
        imageView!!.check(matches(DrawableMatcher.noDrawable()))

        buttonIconOne!!.check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        buttonIconOne!!.check(matches(isEnabled()))

        buttonIconTwo!!.check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        buttonIconTwo!!.check(matches(isEnabled()))
    }

    @Test
    fun checkButtonOneClickShowsSmiley() {
        buttonIconOne!!.perform(click())
        imageView!!.check(matches(withDrawable(R.drawable.smiley)))
    }

    @Test
    fun checkButtonTwoClickShowsSadly() {
        buttonIconTwo!!.perform(click())
        imageView!!.check(matches(withDrawable(R.drawable.sad_face)))
    }

    @Test
    fun checkMultipleTapsOnButtons() {
        checkButtonTwoClickShowsSadly()
        checkButtonOneClickShowsSmiley()

        checkButtonOneClickShowsSmiley()
        checkButtonTwoClickShowsSadly()

        checkButtonTwoClickShowsSadly()
        checkButtonTwoClickShowsSadly()
    }
}
