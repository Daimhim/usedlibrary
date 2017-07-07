package com.example.used.basedecoration;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * 项目名称：com.example.used.basedecoration
 * 项目版本：usedlibrary
 * 创建人：Daimhim
 * 创建时间：2017/7/6 14:17
 * 修改人：Daimhim
 * 修改时间：2017/7/6 14:17
 * 类描述：
 * 修改备注：
 */

public interface DecorationContract {
    interface Draw {
        void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state);
    }

    interface DrawOver {
        void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state);
    }

    interface ItemOffsets {
        void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state);
    }
}
