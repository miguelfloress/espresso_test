package com.example.miguelflores.espressotest.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.miguelflores.espressotest.R;

/**
 * @author miguel.flores.
 */
public class ButtonActivity extends AppCompatActivity {

    private Button button;
    private TextView textView;
    private TextView textViewHidden;

    private int count;

    public static Intent createIntent(Context context) {
        return new Intent(context, ButtonActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_test);
        init();
        initListeners();
    }

    private void init() {
        button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textViewCounter);
        textViewHidden = findViewById(R.id.textViewHidden);
    }

    private void initListeners() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                textView.setText(getString(R.string.clicked, String.valueOf(count)));
                textView.setVisibility(View.VISIBLE);
                if (count >= 10) {
                    textViewHidden.setVisibility(View.VISIBLE);
                    textViewHidden.setText("Hidden Property show");
                }
            }
        });
    }
}
