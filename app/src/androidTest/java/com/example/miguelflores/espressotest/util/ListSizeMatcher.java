package com.example.miguelflores.espressotest.util;

import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

/**
 * Created by miguel.flores on 4/05/2018.
 */

public class ListSizeMatcher extends TypeSafeMatcher {

    private int size;

    private ListSizeMatcher(int size) {
        this.size = size;
    }

    @Override
    protected boolean matchesSafely(Object item) {
        if ((item instanceof ListView)) {
            ListView listView = (ListView) item;
            return listView.getCount() == size;
        }
        if (item instanceof RecyclerView) {
            RecyclerView recyclerView = (RecyclerView) item;
            return recyclerView.getAdapter().getItemCount() == size;
        }
        return false;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("List view size should be " + size);
    }

    public static ListSizeMatcher hasListSize(int size) {
        return new ListSizeMatcher(size);
    }
}
