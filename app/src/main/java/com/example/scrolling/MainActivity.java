package com.example.scrolling;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {


    Adapter adapter;
    Boolean isScrolling = false;
    RecyclerView recyclerView;
    int currentItem, totalItem, scrollOutItems;
    LinearLayoutManager manager;
    ArrayList<String> list;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        manager = new LinearLayoutManager(this);
        manager.setReverseLayout(true);
        progressBar = (ProgressBar) findViewById(R.id.progressbar);
        String[] languages = {"HP", "Dell", "Toshiba", "Lenovo", "Abc", "Xyz", "Sdf", "Mno", "Qpr", "23", "45"};
        list = new ArrayList<String>(Arrays.asList(languages));
        adapter = new Adapter(list, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(manager);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL)
                {
                    isScrolling = true;
                }

            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy)
            {
                super.onScrolled(recyclerView, dx, dy);
                currentItem = manager.getChildCount();
                totalItem = manager.getItemCount();
                scrollOutItems = manager.findFirstVisibleItemPosition();
                if (isScrolling && (currentItem + scrollOutItems == totalItem))
                {
                    isScrolling = false;
                    fetchData();
                }
            }
        });


    }

    private void fetchData()
    {
        progressBar.setVisibility(View.VISIBLE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++)
                {
                    list.add(Math.floor(Math.random() * 100) + "");
                    adapter.notifyDataSetChanged();
                    progressBar.setVisibility(View.GONE);

                }
            }
        }, 2000);
    }



 }

