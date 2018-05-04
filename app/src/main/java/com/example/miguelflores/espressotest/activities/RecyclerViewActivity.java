package com.example.miguelflores.espressotest.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.example.miguelflores.espressotest.R;
import com.example.miguelflores.espressotest.adapters.MyAdapter;
import com.example.miguelflores.espressotest.items.MyTestItem;

import java.util.ArrayList;
import java.util.List;

/**
 * @author miguel.flores.
 */

public class RecyclerViewActivity extends AppCompatActivity implements MyAdapter.MyAdapterListener {

    private RecyclerView recyclerView;
    private MyAdapter adapter;
    private TextView textViewSelection;

    public static Intent createIntent(Context context) {
        return new Intent(context, RecyclerViewActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        recyclerView = findViewById(R.id.recyclerView);
        textViewSelection = findViewById(R.id.textView_selection);
        initRecyclerView();
    }

    private void initRecyclerView() {
        adapter = new MyAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        mockData();
    }

    private void mockData() {
        List<MyTestItem> itemList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            MyTestItem item = new MyTestItem();
            item.setText("Recycler Item Number " + i);
            itemList.add(item);
        }
        adapter.addItems(itemList);
    }

    @Override
    public void onItemSelected(MyTestItem myTestItem) {
        textViewSelection.setText(new String(myTestItem.getText()));
        Log.d("MIRA", textViewSelection.getText().toString());
    }
}
