package com.example.used.decorationitem;

import android.graphics.Rect;

/**
 * 项目名称：com.example.used.decorationitem
 * 项目版本：usedlibrary
 * 创建人：Daimhim
 * 创建时间：2017/6/12 17:21
 * 修改人：Daimhim
 * 修改时间：2017/6/12 17:21
 * 类描述：
 * 修改备注：
 */

public class CacheItem {

    public int cachePosition; //位置
    public Rect cacheDistance; //距离
    public Rect cacheColours;  //颜色

    public CacheItem() {
    }

    public CacheItem(int cachePosition, Rect cacheDistance, Rect cacheColours) {
        this.cachePosition = cachePosition;
        this.cacheDistance = cacheDistance;
        this.cacheColours = cacheColours;
    }

    public void setCachePosition(int cachePosition) {
        this.cachePosition = cachePosition;
    }

    public void setCacheDistance(int left, int top, int right, int bottom) {
        this.cacheDistance = new Rect(left, top, right, bottom);
    }

    public void setCacheColours(int left, int top, int right, int bottom) {
        this.cacheColours = new Rect(left, top, right, bottom);
    }

    @Override
    public String toString() {
        return "CacheItem{" +
                "cachePosition=" + cachePosition +
                ", cacheDistance=" + cacheDistance +
                ", cacheColours=" + cacheColours +
                '}';
    }
}
