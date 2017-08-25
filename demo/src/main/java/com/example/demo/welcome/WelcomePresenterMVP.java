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

public class WelcomePresenterMVP extends MVPBasePresenter<WelcomeContract.View,WelcomeModuleMVP> {


    public WelcomePresenterMVP(WelcomeContract.View view, WelcomeModuleMVP module) {
        super(view, module);
    }

}
