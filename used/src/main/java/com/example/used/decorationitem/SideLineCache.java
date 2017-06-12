package com.example.used.decorationitem;

import android.util.SparseArray;
import android.util.SparseIntArray;

/**
 * 项目名称：com.example.used.decorationitem
 * 项目版本：usedlibrary
 * 创建人：Daimhim
 * 创建时间：2017/6/12 20:00
 * 修改人：Daimhim
 * 修改时间：2017/6/12 20:00
 * 类描述：
 * 修改备注：
 */

public class SideLineCache implements SideLineCacheIble {

    private SparseArray<CacheItem> mSparseArray;

    public SideLineCache() {
        mSparseArray = new SparseArray<>();
    }

    @Override
    public CacheItem getSideLineCache(int position) {
        return mSparseArray.get(position);
    }

    @Override
    public void putSideLineCache(int position, CacheItem cacheItem) {
        mSparseArray.put(position,cacheItem);
    }


    @Override
    public void setMaxRecycledViews(int cacheCount, int cacheMax) {

    }
}
