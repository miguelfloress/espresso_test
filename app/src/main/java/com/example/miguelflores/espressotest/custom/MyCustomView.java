package com.example.miguelflores.espressotest.custom;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.miguelflores.espressotest.R;

/**
 * Created by miguel.flores on 8/05/2018.
 */

public class MyCustomView extends FrameLayout {

    TextView textView1;
    TextView textView2;

    public MyCustomView(@NonNull Context context) {
        this(context, null);
    }

    public MyCustomView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyCustomView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.custom_view, this);
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
    }

    public void fill(String text) {
        String text1 = text.substring(0, 2);
        String text2 = text.substring(2, 4);
        textView1.setText(text1);
        textView2.setText(text2);
    }

    public String getCurrentText() {
        return textView1.getText().toString().concat(textView2.getText().toString());
    }
}
