package com.modernacademy.Itourguide.qrscanner.Activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.modernacademy.Itourguide.R;
import com.modernacademy.Itourguide.qrscanner.Adapter.HistoryAdapter;
import com.modernacademy.Itourguide.qrscanner.Entity.History;
import com.modernacademy.Itourguide.qrscanner.SQLite.ORM.HistoryORM;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HistoryActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    // Init ui elements
    @BindView(R.id.historySwipeRefreshLayout)
    SwipeRefreshLayout historySwipeRefreshLayout;
    @BindView(R.id.historyRecyclerView)
    RecyclerView historyRecyclerView;

    // Variables
    HistoryORM h = new HistoryORM();
    List<History> historyList;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        ButterKnife.bind(this);

        historySwipeRefreshLayout.setOnRefreshListener(this);

        layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        historyRecyclerView.setLayoutManager(layoutManager);
        getData();
    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Отменяем анимацию обновления
                getData();
                historySwipeRefreshLayout.setRefreshing(false);
            }
        },2000);
    }

    private void getData() {
        historyList = h.getAll(getApplicationContext());
        adapter = new HistoryAdapter(historyList);
        historyRecyclerView.setAdapter(adapter);
    }

    public void historyOnClickEvents(View view) {

        switch (view.getId()) {
            case R.id.backButton:
                finish();
                break;
            case R.id.clearButton:
                h.clearAll(getApplicationContext());
                Toast.makeText(getApplicationContext(),"The history is cleared, please refresh this page!",Toast.LENGTH_LONG).show();
                break;
        }
    }
}
