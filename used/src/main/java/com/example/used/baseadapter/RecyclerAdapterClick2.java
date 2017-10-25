package com.example.used.baseadapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * 项目名称：com.example.used.baseadapter
 * 项目版本：usedlibrary
 * 创建人：Daimhim
 * 创建时间：2017/10/23 15:52
 * 修改人：Daimhim
 * 修改时间：2017/10/23 15:52
 * 类描述：
 * 修改备注：
 */

public class RecyclerAdapterClick2 extends RecyclerView.Adapter<RecyclerAdapterClick2.BaseViewHolder> {

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class BaseViewHolder extends RecyclerView.ViewHolder{

        public BaseViewHolder(View itemView) {
            super(itemView);
        }
    }
}
