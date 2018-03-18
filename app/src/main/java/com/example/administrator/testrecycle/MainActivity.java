package com.example.administrator.testrecycle;

import android.animation.ValueAnimator;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView rv = findViewById(R.id.recycleview);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new MyRecycleViewAdapter());
        rv.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        ItemTouchHelper helper = new ItemTouchHelper(new Callback());
        helper.attachToRecyclerView(rv);

    }

    class MyRecycleViewAdapter extends RecyclerView.Adapter<MyRecycleViewAdapter.H> {
        String[] strings = new String[100];

        public MyRecycleViewAdapter() {
            for (int i = 0; i < 100; i++) {
                strings[i] = "item " + i;
            }
        }

        class H extends RecyclerView.ViewHolder {


            public H(View itemView) {
                super(itemView);
            }
        }

        @NonNull
        @Override
        public H onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new H(new TextView(getApplicationContext()));

        }

        @Override
        public void onBindViewHolder(@NonNull H holder, int position) {
            ((TextView) holder.itemView).setText(strings[position]);
        }

        @Override
        public int getItemCount() {
            return 100;
        }
    }
}
