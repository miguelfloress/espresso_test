package com.example.miguelflores.espressotest.activities;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.miguelflores.espressotest.R;
import com.example.miguelflores.espressotest.base.BaseTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class MockBundleTest extends BaseTest{

    public static final String MOCK_TEXT = "Mock Text";

    @Rule
    public ActivityTestRule<ShowBundleActivity> showBundleActivityActivityTestRule = new ActivityTestRule<ShowBundleActivity>(ShowBundleActivity.class){
        @Override
        protected Intent getActivityIntent() {
            Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();
            Intent result = new Intent(context,ShowBundleActivity.class);
            result.putExtra(ShowBundleActivity.KEY_BUNDLE_TEXT,MOCK_TEXT);
            return result;
        }
    };
    private ViewInteraction textContainer;

    @Before
    public void setUp(){
        textContainer = onView(withId(R.id.text_container));
    }

    @Test
    public void checkMockedText(){
        sleepPresentation(500);
        textContainer.check(matches(withText(MOCK_TEXT)));
    }
}
