package com.example.used.decorationitem;

import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

/**
 * 项目名称：com.example.used.decorationitem
 * 项目版本：usedlibrary
 * 创建人：Daimhim
 * 创建时间：2017/6/12 17:12
 * 修改人：Daimhim
 * 修改时间：2017/6/12 17:12
 * 类描述：
 * 修改备注：
 */

public interface SideLineCacheIble {
    public CacheItem getSideLineCache(int position);
    public void putSideLineCache(int position,CacheItem cacheItem);
    public void setMaxRecycledViews(int cacheCount, int cacheMax);
}
