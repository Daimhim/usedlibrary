package com.example.used.baseadapter;

import android.view.ViewGroup;

/**
 * 项目名称：com.example.used.baseadapter
 * 项目版本：usedlibrary
 * 创建人：Daimhim
 * 创建时间：2017/6/9 16:01
 * 修改人：Daimhim
 * 修改时间：2017/6/9 16:01
 * 类描述：
 * 修改备注：
 */

public class ExpandableRecyclerAdapter<VHG extends RecyclerAdapterClick.BaseViewHolder,VHC extends RecyclerAdapterClick.BaseViewHolder> extends RecyclerAdapterClick<RecyclerAdapterClick.BaseViewHolder> {
    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder baseViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
