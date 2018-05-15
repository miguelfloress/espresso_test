package com.example.miguelflores.espressotest.util;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.test.espresso.matcher.BoundedMatcher;
import android.view.View;
import android.widget.ImageView;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

/**
 * Created by miguel.flores
 */
public class DrawableMatcher extends TypeSafeMatcher {
    //BoundedMatcher<View,ImageView> {

    private int expectedId;

    public DrawableMatcher(int expectedId) {
        //super(ImageView.class);
        this.expectedId = expectedId;
    }

    @Override
    protected boolean matchesSafely(Object item) {
        if (!(item instanceof ImageView)) {
            return false;
        }
        ImageView imageView = (ImageView) item;
        if (expectedId < 0) {
            return imageView.getDrawable() == null;
        }
        Resources resources = imageView.getContext().getResources();
        Drawable expectedDrawable = resources.getDrawable(expectedId);
        if (expectedDrawable == null) {
            return false;
        }
        Bitmap bitmap = getBitmap(imageView.getDrawable());
        Bitmap otherBitmap = getBitmap(expectedDrawable);
        return bitmap.sameAs(otherBitmap);
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("with drawable from resource id: ")
                   .appendValue(expectedId);
    }

    private Bitmap getBitmap(Drawable drawable) {
        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(),
                drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmap;
    }

    public static Matcher<View> withDrawable(final int resourceId) {
        return new DrawableMatcher(resourceId);
    }

    public static Matcher<View> noDrawable() {
        return new DrawableMatcher(-1);
    }
}
