package com.example.used.decorationitem;

import android.graphics.Canvas;
import android.support.v7.widget.RecyclerView;

/**
 * 项目名称：com.example.used.decorationitem
 * 项目版本：usedlibrary
 * 创建人：Daimhim
 * 创建时间：2017/6/12 20:24
 * 修改人：Daimhim
 * 修改时间：2017/6/12 20:24
 * 类描述：
 * 修改备注：
 */

public interface SideLineDrawIble {
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state);

    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state);

}
