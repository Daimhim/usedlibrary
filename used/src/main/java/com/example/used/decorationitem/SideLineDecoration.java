package com.example.used.decorationitem;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
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

public abstract class SideLineDecoration extends RecyclerView.ItemDecoration {
    private SideLineCacheIble mLineCacheIble;
    /**
     * 画笔
     */
    private Paint mPaint;

    private Context mContext;

    /**
     * 方向 垂直、水平、十字
     */
    public static final int VERTICAL = LinearLayoutManager.VERTICAL;

    public static final int HORIZONTAL = LinearLayoutManager.HORIZONTAL;

    public static final int VERTICAL_CROSS = 2;

    public static final int HORIZONTAL_CROSS = 3;

    private int mOrientation = VERTICAL;  //方向

    private SideLineDecoration(Builder builder){
//        new AlertDialog()
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        int childCount = parent.getChildCount();
        View childAt;
        int position;
        CacheItem cacheItem;
        for (int i = 0; i < childCount; i++) {
            childAt = parent.getChildAt(i);
            position = parent.getChildAdapterPosition(childAt);
            //绘制边线 获取用户定义的绘制类
            cacheItem = state.<CacheItem>get(position);
            drawLine(c,cacheItem.cacheDistance,cacheItem.cacheColours,childAt);
        }
    }
    /**
     * 绘制类 根据缓存对象mViewHashMap中的数据 去绘制
     *
     * @param c            画布
     * @param cacheDistance      相对于Item四边的边距
     * @param cacheColours 相对于四边的边距的颜色
     * @param childAt      当前Item的View对象
     */
    private void drawLine(Canvas c, Rect cacheDistance, Rect cacheColours, View childAt) {
        int startX;
        int startY;
        int stopX;
        int stopY;
        if (cacheDistance.left != 0) {
            startX = childAt.getLeft() - (cacheDistance.left / 2);
            startY = childAt.getTop() - cacheDistance.top;
            stopX = childAt.getLeft() - (cacheDistance.left / 2);
            stopY = childAt.getBottom() + cacheDistance.bottom;
            if (cacheColours.left != 0) {
                mPaint.setColor(ContextCompat.getColor(mContext, cacheColours.left));
            }
            mPaint.setStrokeWidth(cacheDistance.left);
            c.drawLine(startX, startY, stopX, stopY, mPaint);
        }
        if (cacheDistance.right != 0) {
            startX = childAt.getRight() + (cacheDistance.right / 2);
            startY = childAt.getTop() - cacheDistance.top;
            stopX = childAt.getRight() + (cacheDistance.right / 2);
            stopY = childAt.getBottom() + cacheDistance.bottom;
            if (cacheColours.right != 0) {
                mPaint.setColor(ContextCompat.getColor(mContext, cacheColours.right));
            }
            mPaint.setStrokeWidth(cacheDistance.right);
            c.drawLine(startX, startY, stopX, stopY, mPaint);
        }
        if (cacheDistance.top != 0) {
            startX = childAt.getLeft() - cacheDistance.left;
            startY = childAt.getTop() - (cacheDistance.top / 2);
            stopX = childAt.getRight() + cacheDistance.right;
            stopY = childAt.getTop() - (cacheDistance.top / 2);
            if (cacheColours.top != 0) {
                mPaint.setColor(ContextCompat.getColor(mContext, cacheColours.top));
            }
            mPaint.setStrokeWidth(cacheDistance.top);
            c.drawLine(startX, startY, stopX, stopY, mPaint);
        }
        if (cacheDistance.bottom != 0) {
            startX = childAt.getLeft() - cacheDistance.left;
            startY = childAt.getBottom() + (cacheDistance.bottom / 2);
            stopX = childAt.getRight() + cacheDistance.right;
            stopY = childAt.getBottom() + (cacheDistance.bottom / 2);
            if (cacheColours.bottom != 0) {
                mPaint.setColor(ContextCompat.getColor(mContext, cacheColours.bottom));
            }
            mPaint.setStrokeWidth(cacheDistance.bottom);
            c.drawLine(startX, startY, stopX, stopY, mPaint);
        }
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {

    }

    @Override
    public abstract void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state);

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
