package com.example.demo.tellajoke;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.basic.BaseFragment;
import com.example.basic.utils.QLog;
import com.example.demo.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;



/**
 * 项目名称：com.example.demo.tellajoke
 * 项目版本：usedlibrary
 * 创建人：Daimhim
 * 创建时间：2017/8/4 9:28
 * 修改人：Daimhim
 * 修改时间：2017/8/4 9:28
 * 类描述：
 * 修改备注：
 */

public class TellJokeFragment extends BaseFragment<TellJokeContract.Presenter, TellJokeModule> implements TellJokeContract.View, OnRefreshListener {



    RecyclerView mRvRecyclerview;

    SmartRefreshLayout mSrlSmartrefreshlayout;

    int page = 1;

    @Override
    protected View onSetContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_telljoke, container, false);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onSetUpView(View view, Bundle savedInstanceState) {
//        mRvRecyclerview = view.findViewById(R.id.rv_recyclerview);
        mSrlSmartrefreshlayout = view.findViewById(R.id.srl_smartrefreshlayout);
        mSrlSmartrefreshlayout.setOnRefreshListener(this);
        presenter.getJokeSet(page,20);
        QLog.i(TAG,"presenter");
    }

    @Override
    protected void onSetEntry() {

    }


    @Override
    public void onRefresh(RefreshLayout refreshLayout) {
//        presenter.getJokeSet(page,20);
        mSrlSmartrefreshlayout.finishRefresh(20);
    }
}
