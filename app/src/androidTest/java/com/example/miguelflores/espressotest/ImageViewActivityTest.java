package com.example.miguelflores.espressotest;

import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.miguelflores.espressotest.activities.ImageViewActivity;
import com.example.miguelflores.espressotest.util.DrawableMatcher;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.Visibility;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static com.example.miguelflores.espressotest.util.DrawableMatcher.withDrawable;

/**
 * @author miguel.flores.
 */
@RunWith(AndroidJUnit4.class)
public class ImageViewActivityTest {

    @Rule
    public ActivityTestRule<ImageViewActivity> mainActivityRule = new ActivityTestRule<>(ImageViewActivity.class);
    private ViewInteraction imageView;
    private ViewInteraction buttonIconOne;
    private ViewInteraction buttonIconTwo;

    @Before
    public void setUp() {
        imageView = onView(withId(R.id.imageView));
        buttonIconOne = onView(withId(R.id.buttonIconOne));
        buttonIconTwo = onView(withId(R.id.buttonIconTwo));
    }

    @Test
    public void checkInitialState() {
        imageView.check(matches(DrawableMatcher.noDrawable()));

        buttonIconOne.check(matches(withEffectiveVisibility(Visibility.VISIBLE)));
        buttonIconOne.check(matches(isEnabled()));

        buttonIconTwo.check(matches(withEffectiveVisibility(Visibility.VISIBLE)));
        buttonIconTwo.check(matches(isEnabled()));
    }

    @Test
    public void checkButtonOneClickShowsSmiley() {
        buttonIconOne.perform(click());
        imageView.check(matches(withDrawable(R.drawable.smiley)));
    }

    @Test
    public void checkButtonTwoClickShowsSadly() {
        buttonIconTwo.perform(click());
        imageView.check(matches(withDrawable(R.drawable.sad_face)));
    }

    @Test
    public void checkMultipleTapsOnButtons(){
        checkButtonTwoClickShowsSadly();
        checkButtonOneClickShowsSmiley();

        checkButtonOneClickShowsSmiley();
        checkButtonTwoClickShowsSadly();

        checkButtonTwoClickShowsSadly();
        checkButtonTwoClickShowsSadly();
    }
}
