package com.example.demo.welcome;

import com.example.demo.mvp.MVPBasePresenter;

/**
 * 项目名称：com.example.demo.welcome
 * 项目版本：usedlibrary
 * 创建人：Daimhim
 * 创建时间：2017/8/3 16:02
 * 修改人：Daimhim
 * 修改时间：2017/8/3 16:02
 * 类描述：
 * 修改备注：
 */

public class WelcomePresenter extends MVPBasePresenter<WelcomeContract.View,WelcomeContract.Module> {


    public WelcomePresenter(WelcomeContract.View view, WelcomeContract.Module module) {
        super(view, module);
    }

}
