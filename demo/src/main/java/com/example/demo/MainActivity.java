package com.example.demo;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.used.baseadapter.ExpandableRecyclerAdapter;
import com.example.used.baseadapter.RecyclerAdapterClick;
import com.example.used.decoration.DecorationBuilder;
import com.example.used.decoration.LinearDecoration;
import com.example.used.toolset.Dimension;
import com.example.used.view.RadioGroupFlowLayout;
import com.example.xuyuan.adapter.BaseAdaptyer;

import java.util.ArrayList;
import java.util.List;

import static android.util.TypedValue.COMPLEX_UNIT_PX;


public class MainActivity extends AppCompatActivity implements RecyclerAdapterClick.OnItemClickListener, ExpandableRecyclerAdapter.OnGroupItemClickListener, ExpandableRecyclerAdapter.OnChildItemClickListener, View.OnClickListener {

    private RecyclerView mRecyclerView;
    private Context mContext;
    DemoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        findViewById(R.id.fab_FloatingActionButton).setOnClickListener(this);
        findViewById(R.id.fab_FloatingActionButton_one).setOnClickListener(this);
        findViewById(R.id.fab_FloatingActionButton_two).setOnClickListener(this);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_RecyclerView);
        adapter = new DemoAdapter(this, getData(20));
        adapter.setOnItemClickListener(this);
        adapter.setOnGroupItemClickListeners(this);
        adapter.setOnChildItemClickListeners(this);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.addItemDecoration(DecorationBuilder
                .Builder(new LinearDecoration(this))
                .setDividerWidth((int) Dimension.applyDimension(COMPLEX_UNIT_PX, 1, this))
                .setDividerColor(R.color.colorAccent)
                .builder());

    }

    private List<Pair<String, List<String>>> getData(int size) {
        List<Pair<String, List<String>>> pairList = new ArrayList<>();
        List<String> list = null;
        for (int i = 0; i < size; i++) {
            list = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                if (i == 15) {
                    break;
                }
                list.add("Child:" + j);
            }
            pairList.add(new Pair<String, List<String>>("Group:" + i, list));
        }
        return pairList;
    }

    @Override
    public void onItemClick(View view, int position) {
        switch (view.getId()) {
            case R.id.tv_content:
                adapter.notifyGroupPositionChanged(position);
                break;
            default:
                break;
        }
    }

    @Override
    public void onGroupItemClick(View view, int groupPosition) {
        switch (view.getId()) {
            case R.id.tv_content:
                adapter.remove(groupPosition);
                break;
            default:
                break;
        }
    }

    @Override
    public void onGroupItemClick(View view, int groupPosition, int childPosition) {
        Snackbar.make(view, groupPosition + ":View:" + childPosition, Snackbar.LENGTH_SHORT).show();
        Toast.makeText(this, groupPosition + ":View:" + childPosition, Toast.LENGTH_SHORT).show();
    }
    private Pair<String, List<String>> getPair(int groupPosition,int size){
        List<String> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add("Child++:" + i);
        }
        return new Pair<>("Group++:" + groupPosition,list);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab_FloatingActionButton:
                adapter.addGroup(5,getPair(5,5));
                break;
            case R.id.fab_FloatingActionButton_one:
                break;
            case R.id.fab_FloatingActionButton_two:
                break;
            default:
                break;
        }
        Snackbar.make(v, ":View:", Snackbar.LENGTH_SHORT).show();
    }
}
