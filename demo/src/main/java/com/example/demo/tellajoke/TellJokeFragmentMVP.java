package com.example.demo.tellajoke;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.demo.mvp.MVPBaseFragment;
import com.example.basic.utils.QLog;
import com.example.demo.R;
import com.example.demo.adapter.TellJokeAdapter;
import com.example.demo.bean.Joke;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.List;


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

public class TellJokeFragmentMVP extends MVPBaseFragment<TellJokeContract.Presenter, TellJokeModuleMVP> implements TellJokeContract.View, OnRefreshListener, OnLoadmoreListener {



    RecyclerView mRvRecyclerview;

    SmartRefreshLayout mSrlSmartrefreshlayout;

    int page = 1;
    private TellJokeAdapter mTellJokeAdapter;

    @Override
    protected View onSetContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_telljoke, container, false);
    }

    @Override
    protected void onSetUpView(View view, Bundle savedInstanceState) {
        mRvRecyclerview = view.findViewById(R.id.rv_recyclerview);
        mSrlSmartrefreshlayout = view.findViewById(R.id.srl_smartrefreshlayout);
        mSrlSmartrefreshlayout.setOnRefreshListener(this);
        mSrlSmartrefreshlayout.setOnLoadmoreListener(this);
        mTellJokeAdapter = new TellJokeAdapter(mContext);
        mRvRecyclerview.setAdapter(mTellJokeAdapter);
    }

    @Override
    protected void onSetEntry() {
        presenter.getJokeSet(page,20);
        QLog.i(TAG,"presenter");
    }


    @Override
    public void onRefresh(RefreshLayout refreshLayout) {
        page = 1;
        presenter.getJokeSet(page,20);
        mSrlSmartrefreshlayout.finishRefresh();
    }

    @Override
    public void setValue(List<Joke.ResultBean.DataBean> beanList) {
        if (page == 1) {
            mTellJokeAdapter.clear();
            mTellJokeAdapter.refresh(beanList);
        }else {
            mTellJokeAdapter.addAll(beanList);
        }
        QLog.i(TAG,beanList.toString());
    }

    @Override
    public void onLoadmore(RefreshLayout refreshLayout) {
        ++page;
        presenter.getJokeSet(page,20);
        mSrlSmartrefreshlayout.finishLoadmore();
    }
}
