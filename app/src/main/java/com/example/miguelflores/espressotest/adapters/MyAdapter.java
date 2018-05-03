package com.example.miguelflores.espressotest.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.miguelflores.espressotest.R;
import com.example.miguelflores.espressotest.items.MyTestItem;

import java.util.ArrayList;
import java.util.List;

/**
 * @author miguel.flores.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyAdapterViewHolder> {

    private List<MyTestItem> itemList;
    private MyAdapterListener listener;

    public MyAdapter(MyAdapterListener listener) {
        this.itemList = new ArrayList<>();
        this.listener = listener;
    }

    @Override
    public MyAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyAdapterViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(MyAdapterViewHolder holder, int position) {
        MyTestItem item = itemList.get(position);
        holder.textView.setText(item.getText());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public void addItems(List<MyTestItem> itemList) {
        this.itemList = itemList;
        notifyDataSetChanged();
    }

    public class MyAdapterViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public MyAdapterViewHolder(ViewGroup itemView) {
            super(LayoutInflater.from(itemView.getContext()).inflate(R.layout.item_recycler_test, itemView, false));
            textView = this.itemView.findViewById(R.id.textView);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null && getAdapterPosition() != RecyclerView.NO_POSITION) {
                        listener.onItemSelected(itemList.get(getAdapterPosition()));
                    }
                }
            });
        }
    }

    public interface MyAdapterListener {
        void onItemSelected(MyTestItem myTestItem);
    }
}
