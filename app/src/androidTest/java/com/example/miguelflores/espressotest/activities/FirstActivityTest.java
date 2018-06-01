package com.example.miguelflores.espressotest.activities;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.miguelflores.espressotest.R;
import com.example.miguelflores.espressotest.base.BaseTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by miguel.flores on 31/05/2018.
 */

@RunWith(AndroidJUnit4.class)
public class FirstActivityTest extends BaseTest{

    @Rule
    public ActivityTestRule<FirstActivity> mainActivityRule = new ActivityTestRule<FirstActivity>(FirstActivity.class);

    @Test
    public void checkStateTest(){
        Espresso.onView(ViewMatchers.withId(R.id.textView)).check(ViewAssertions.matches(ViewMatchers.withText("Espresso Test")));
        sleepPresentation(2000);
    }

}
