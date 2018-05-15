package com.example.miguelflores.espressotest.activities;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.IdlingRegistry;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;

import com.example.miguelflores.espressotest.R;
import com.example.miguelflores.espressotest.base.BaseTest;
import com.example.miguelflores.espressotest.presenter.ServicePresenter;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.Matchers.not;

/**
 * @author miguel.flores.
 */
@RunWith(MockitoJUnitRunner.class)
public class ServiceActivityTest extends BaseTest {

    private ServicePresenter presenter;

    @Rule
    public ActivityTestRule<ServiceActivity> mainActivityRule = new ActivityTestRule<>(ServiceActivity.class);

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void callService() {
        IdlingRegistry.getInstance().register(mainActivityRule.getActivity().getCountingIdlingResource());
        Espresso.onView(ViewMatchers.withId(R.id.button)).perform(ViewActions.click());
        sleep(2000);
        Espresso.onView(ViewMatchers.withId(R.id.textView_result)).check(ViewAssertions.matches(not(ViewMatchers.withText("error"))));
    }

    @Test
    public void callServiceMock() {
        presenter = new ServicePresenter(mainActivityRule.getActivity()) {
            @Override
            public void fireService() {
                presenter.handleResponse("This is my mock response");
            }
        };
        IdlingRegistry.getInstance().register(mainActivityRule.getActivity().getCountingIdlingResource());
        mainActivityRule.getActivity().setPresenter(presenter);
        Espresso.onView(ViewMatchers.withId(R.id.button)).perform(ViewActions.click());
        sleep(2000);
        Espresso.onView(ViewMatchers.withId(R.id.textView_result)).check(ViewAssertions.matches(not(ViewMatchers.withText("error"))));
    }
}