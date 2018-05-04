package com.example.miguelflores.espressotest.util;

import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.view.View;

import org.hamcrest.Matcher;

/**
 * Created by miguel.flores on 4/05/2018.
 */

public class MyViewAction implements ViewAction {

    private int viewId;

    private MyViewAction(int viewId) {
        this.viewId = viewId;
    }

    @Override
    public Matcher<View> getConstraints() {
        return null;
    }

    @Override
    public String getDescription() {
        return "View id " + viewId + " not found";
    }

    @Override
    public void perform(UiController uiController, View view) {
        view.findViewById(viewId).performClick();
    }

    public static MyViewAction performClickOnChildWithId(int viewId) {
        return new MyViewAction(viewId);
    }
}
