package com.example.used.basedecoration;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * 项目名称：com.example.used.basedecoration
 * 项目版本：usedlibrary
 * 创建人：Daimhim
 * 创建时间：2017/7/6 14:14
 * 修改人：Daimhim
 * 修改时间：2017/7/6 14:14
 * 类描述：
 * 修改备注：
 */

public class BaseDecoration extends RecyclerView.ItemDecoration {
    private DecorationContract.Draw mDraw;
    private DecorationContract.DrawOver mDrawOver;
    private DecorationContract.ItemOffsets mItemOffsets;

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        if (null != mDraw) {
            mDraw.onDraw(c, parent, state);
        }
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
        if (null != mDrawOver) {
            mDrawOver.onDrawOver(c, parent, state);
        }
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        if (null != mItemOffsets) {
            mItemOffsets.getItemOffsets(outRect, view, parent, state);
        }
    }

    public void setDraw(DecorationContract.Draw draw) {
        mDraw = draw;
    }

    public void setDrawOver(DecorationContract.DrawOver drawOver) {
        mDrawOver = drawOver;
    }

    public void setItemOffsets(DecorationContract.ItemOffsets itemOffsets) {
        mItemOffsets = itemOffsets;
    }

    public DecorationContract.Draw getDraw() {
        return mDraw;
    }

    public DecorationContract.DrawOver getDrawOver() {
        return mDrawOver;
    }

    public DecorationContract.ItemOffsets getItemOffsets() {
        return mItemOffsets;
    }

}
