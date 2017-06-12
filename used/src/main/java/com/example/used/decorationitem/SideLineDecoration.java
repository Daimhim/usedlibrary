package com.example.used.decorationitem;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * 项目名称：com.example.used.decorationitem
 * 项目版本：usedlibrary
 * 创建人：Daimhim
 * 创建时间：2017/6/12 16:54
 * 修改人：Daimhim
 * 修改时间：2017/6/12 16:54
 * 类描述：
 * 修改备注：
 */

public class SideLineDecoration extends RecyclerView.ItemDecoration {
    private SideLineCacheIble mLineCacheIble;

    private SideLineDecoration(Builder builder){
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
//        state.put();
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
    }

    public static class Builder {
//        private final SideLineAttribute mAttribute;

        public Builder() {
        }
    }

    public static class SideLineAttribute {
        public Context mContext;
        public SideLineCacheIble mLineCacheIble;
    }
}
