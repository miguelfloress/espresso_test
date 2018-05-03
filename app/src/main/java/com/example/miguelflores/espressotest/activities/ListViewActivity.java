package com.example.miguelflores.espressotest.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.miguelflores.espressotest.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @author miguel.flores.
 */
public class ListViewActivity extends AppCompatActivity {

    private ListView listView;
    private TextView textViewSelection;
    private ArrayAdapter<String> arrayAdapter;

    public static Intent createIntent(Context context) {
        return new Intent(context, ListViewActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        init();
    }

    private void init() {
        textViewSelection = findViewById(R.id.textView_selection);
        listView = findViewById(R.id.listView);

        arrayAdapter = new ArrayAdapter<String>(this, R.layout.item_list_view, R.id.textView);
        arrayAdapter.addAll(mockData());
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String text = (String) adapterView.getItemAtPosition(i);
                textViewSelection.setText(text);
            }
        });
    }

    private List<String> mockData() {
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            stringList.add("List item " + i);
        }
        return stringList;
    }
}
