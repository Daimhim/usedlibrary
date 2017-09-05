package com.example.demo.mvp;

/**
 * 项目名称：com.example.demo
 * 项目版本：usedlibrary
 * 创建人：Daimhim
 * 创建时间：2017/8/2 14:35
 * 修改人：Daimhim
 * 修改时间：2017/8/2 14:35
 * 类描述：
 * 修改备注：
 */

public interface MVPBaseContract {

    public interface View{
        void setPresenterAndModule();

        void showProgressDialog();

        void dissProgressDialog();

        void showError(String error);
    }

    public interface Presenter{

        void onStart();

        void onStop();
    }
    public interface Module{

    }
}
