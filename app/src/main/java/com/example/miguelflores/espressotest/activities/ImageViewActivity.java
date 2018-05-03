package com.example.miguelflores.espressotest.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.miguelflores.espressotest.R;

/**
 * @author miguel.flores.
 */
public class ImageViewActivity extends AppCompatActivity {

    public static Intent createIntent(Context context) {
        return new Intent(context, ImageViewActivity.class);
    }

    private ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);
        imageView = findViewById(R.id.imageView);
        initListeners();
    }

    private void initListeners() {
        findViewById(R.id.buttonIconOne).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleIconOneClicked();
            }
        });
        findViewById(R.id.buttonIconTwo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleIconTwoClicked();
            }
        });
    }

    private void handleIconOneClicked() {
        imageView.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.smiley));
        imageView.setBackgroundColor(ContextCompat.getColor(this, R.color.yellow));
    }

    private void handleIconTwoClicked() {
        imageView.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.sad_face));
        imageView.setBackgroundColor(ContextCompat.getColor(this, R.color.green));
    }
}
