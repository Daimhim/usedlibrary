package com.example.basic;

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

public interface BaseContract {

    interface View{

        void setPresenterAndModule();

        void showProgressDialog();

        void dissProgressDialog();

        void showError(String error);
    }

    interface Presenter{

        void onStart();

        void onStop();
    }
}
