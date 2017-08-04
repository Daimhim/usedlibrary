package com.example.demo.tellajoke;

import android.os.Bundle;

import com.example.basic.BaseActivity;

/**
 * 项目名称：com.example.demo.tellajoke
 * 项目版本：usedlibrary
 * 创建人：Daimhim
 * 创建时间：2017/8/4 9:27
 * 修改人：Daimhim
 * 修改时间：2017/8/4 9:27
 * 类描述：
 * 修改备注：
 */

public class TellJokeActivity extends BaseActivity<TellJokeContract.Presenter,TellJokeModule> {
    TellJokeFragment mTellJokeFragment;
    @Override
    protected void setPresenterAndModule() {
        module = new TellJokeModule();
        mTellJokeFragment = new TellJokeFragment();
        presenter = new TellJokePresenter(mTellJokeFragment,module);
        mTellJokeFragment.setPresenterAndModule(presenter,module);
    }

    @Override
    protected void onSetContentView() {
        getSupportFragmentManager().beginTransaction().add(mTellJokeFragment,TAG).commit();

    }

    @Override
    protected void onSetUpView(Bundle savedInstanceState) {

    }

    @Override
    protected void onSetEntry() {

    }
}
