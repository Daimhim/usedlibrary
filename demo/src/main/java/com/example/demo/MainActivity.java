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


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
