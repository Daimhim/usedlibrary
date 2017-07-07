package com.example.used.basedecoration;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * 项目名称：com.example.used.basedecoration
 * 项目版本：usedlibrary
 * 创建人：Daimhim
 * 创建时间：2017/7/6 14:34
 * 修改人：Daimhim
 * 修改时间：2017/7/6 14:34
 * 类描述：
 * 修改备注：
 */

public abstract class BaseItemOffsets implements DecorationContract.ItemOffsets{
    int ORIENTATION = -1;
    RecyclerView.LayoutManager mLayoutManager;
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {

    }
}
