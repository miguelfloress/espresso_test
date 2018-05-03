package com.example.miguelflores.espressotest.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.example.miguelflores.espressotest.R;

/**
 * @author miguel flores.
 */

public class EditTextActivity extends AppCompatActivity {

    private EditText editText;

    public static Intent createIntent(Context context) {
        return new Intent(context, EditTextActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edittext_view);
        initView();
    }

    private void initView() {
        editText = (EditText) findViewById(R.id.editText);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                editText.setEnabled(charSequence.length() < 8);

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }
}
