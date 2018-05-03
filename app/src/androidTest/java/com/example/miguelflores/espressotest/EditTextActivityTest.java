package com.example.miguelflores.espressotest;

import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.miguelflores.espressotest.activities.EditTextActivity;
import com.example.miguelflores.espressotest.base.BaseTest;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withHint;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.action.ViewActions.*;

/**
 * @author miguel flores.
 */
@RunWith(AndroidJUnit4.class)
public class EditTextActivityTest extends BaseTest {

    @Rule
    public ActivityTestRule<EditTextActivity> mainActivityRule = new ActivityTestRule<EditTextActivity>(EditTextActivity.class);

    @Test
    public void checkInitialState() {
        ViewInteraction editText = onView(withId(R.id.editText));
        //check initial text value
        editText.check(matches(withText(R.string.edittext_text)));
        //check initial hint
        editText.check(matches(withHint(R.string.hint_edittext_text)));
        //check accessibility
        editText.check(matches(withContentDescription(R.string.accessibility_edittext)));
    }

    /**
     * NOTE to make typeText works on some devices you need to do this
     * Go to Settings -> Language & Input -> switch the Default Input to Sample Soft Keyboard.
     * Here we check that when we delete the text and write another text the text corresponds to the one we write
     */
    @Test
    public void checkCorrectInput() {
        ViewInteraction editText = onView(withId(R.id.editText));
        String text = "abc";
        editText.perform(clearText());
        sleepPresentation(1000);
        editText.perform(typeText(text));
        sleepPresentation(1000);
        editText.check(matches(withText(text)));
    }

    /**
     * Check edit text is disabled when it reach the limit of 8 characters
     */
    @Test
    public void checkDisableEditTextWhen8CharsInput() {
        ViewInteraction editText = onView(withId(R.id.editText));
        String text = "1234567";
        editText.perform(clearText());
        sleepPresentation(1000);
        editText.perform(typeText(text));
        sleepPresentation(1000);
        editText.check(matches(isEnabled()));
        text = "8";
        editText.perform(typeText(text));
        sleepPresentation(1000);
        editText.check(matches(Matchers.not(isEnabled())));
    }

}
