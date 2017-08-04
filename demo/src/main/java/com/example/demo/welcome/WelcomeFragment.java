package com.example.demo.welcome;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.basic.BaseFragment;

/**
 * 项目名称：com.example.demo.welcome
 * 项目版本：usedlibrary
 * 创建人：Daimhim
 * 创建时间：2017/8/2 15:15
 * 修改人：Daimhim
 * 修改时间：2017/8/2 15:15
 * 类描述：
 * 修改备注：
 */

public class WelcomeFragment extends BaseFragment<WelcomeContract.Presenter,WelcomeModule> {


    @Override
    protected View onSetContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return null;
    }

    @Override
    protected void onSetUpView(View view, Bundle savedInstanceState) {

    }

    @Override
    protected void onSetEntry() {

    }
}
