package com.example.used.baseadapter;

import android.util.Pair;
import android.util.SparseIntArray;
import android.view.View;
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

public abstract class ExpandableRecyclerAdapter<VHG extends RecyclerAdapterClick.BaseViewHolder, VHC extends RecyclerAdapterClick.BaseViewHolder>
        extends RecyclerAdapterClick<RecyclerAdapterClick.BaseViewHolder> {
    private OnGroupItemClickListener mOnGroupItemClickListeners;
    private OnGroupItemLongClickListener mOnGroupItemLongClickListener;

    private OnChildItemClickListener mOnChildItemClickListeners;
    private OnChildItemLongClickListener mOnChildItemLongClickListener;

    /**
     * Key groupPosition
     * Value group>Position
     */
    private SparseIntArray mSparseArray;

    public final void notifyPositionChanged() {
        if (null == mSparseArray) {
            mSparseArray = new SparseIntArray();
        } else {
            mSparseArray.clear();
        }
        int num = 0;
        for (int i = 0; i < getGroupCount(); i++) {
            mSparseArray.put(i, num);
            num += getChildrenCount(i);
            num++;
        }
        mSparseArray.put(getGroupCount(), num);
    }

    public final void notifyGroupPositionChanged(int groupPosition) {
        int num = 0;
        for (int i = 0; i < groupPosition; i++) {
            num += getChildrenCount(i);
            num++;
        }
        mSparseArray.put(getGroupCount(), num);
    }

    public Pair<Integer, Integer> indexOfPosition(int position) {
        int num = 0;
        for (int i = 0; i < getGroupCount(); i++) {
            num += getChildrenCount(i);
            num++;
            if (num > position) {
                num -= getChildrenCount(i);
                num--;
                for (int j = 0; j < getChildrenCount(i); j++) {
                    num++;
                    if (num == position) {
                        return new Pair<>(i, j);
                    }
                }
            }
        }
        return new Pair<>(0, 0);
    }

    public Pair<Integer,Integer> indexOfGroupPosition(int groupPosition){
        int num = 0;
        for (int i = 0; i < groupPosition; i++) {
            num += getChildrenCount(i);
            num++;
        }
        return new Pair<>(groupPosition,num);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        if (viewType < 0) {
            return onCreateGroupViewHolder(viewGroup, viewType);
        } else {
            return onCreateChildViewHolder(viewGroup, viewType);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerAdapterClick.BaseViewHolder baseViewHolder, int position) {
        int ofValue = mSparseArray.indexOfValue(position);
        if (ofValue < 0) {
            Pair<Integer, Integer> integerPair = indexOfPosition(position);
            onBindChildViewHolder((VHC) baseViewHolder, integerPair.first, integerPair.second);
        } else {
            onBindGroupViewHolder((VHG) baseViewHolder, ofValue);
        }
    }

    @Override
    public int getItemViewType(int position) {
        int ofValue = mSparseArray.indexOfValue(position);
        if (ofValue < 0) {
            Pair<Integer, Integer> integerPair = indexOfPosition(position);
            return getChildItemViewType(integerPair.first, integerPair.second);
        } else {
            return -getGroupItemViewType(ofValue);
        }
    }

    @Override
    public int getItemCount() {
        int num = 0;
        for (int i = 0; i < getGroupCount(); i++) {
            num += getChildrenCount(i);
        }
        return num + getGroupCount();
    }

    public int getGroupItemViewType(int groupPosition) {
        return 1;
    }

    public int getChildItemViewType(int groupPosition, int childPosition) {
        return 1;
    }

    @Override
    protected void onItemClickListener(View v, int position, OnItemClickListener itemClickListener) {
        int ofValue = mSparseArray.indexOfValue(position);
        if (ofValue < 0) { //Child
            if ( null != mOnChildItemClickListeners){
                Pair<Integer, Integer> integerPair = indexOfPosition(position);
                mOnChildItemClickListeners.onGroupItemClick(v,integerPair.first,integerPair.second);
            }
        } else {
            if ( null != mOnGroupItemClickListeners){
                mOnGroupItemClickListeners.onGroupItemClick(v, ofValue);
            }
        }
    }

    @Override
    protected void onItemLongClickListener(View v, int position, OnItemLongClickListener itemLongClickListener) {
        int ofValue = mSparseArray.indexOfValue(position);
        if (ofValue < 0) { //Child
            if ( null != mOnChildItemLongClickListener){
                Pair<Integer, Integer> integerPair = indexOfPosition(position);
                mOnChildItemLongClickListener.onGroupItemLongClick(v,integerPair.first,integerPair.second);
            }
        } else {
            if ( null != mOnGroupItemLongClickListener){
                mOnGroupItemLongClickListener.onGroupItemLongClick(v, ofValue);
            }
        }
    }

    public void setOnGroupItemClickListeners(OnGroupItemClickListener onGroupItemClickListeners) {
        mOnGroupItemClickListeners = onGroupItemClickListeners;
    }

    public void setOnGroupItemLongClickListener(OnGroupItemLongClickListener onGroupItemLongClickListener) {
        mOnGroupItemLongClickListener = onGroupItemLongClickListener;
    }

    public void setOnChildItemClickListeners(OnChildItemClickListener onChildItemClickListeners) {
        mOnChildItemClickListeners = onChildItemClickListeners;
    }

    public void setOnChildItemLongClickListener(OnChildItemLongClickListener onChildItemLongClickListener) {
        mOnChildItemLongClickListener = onChildItemLongClickListener;
    }

    public abstract int getGroupCount();

    public abstract int getChildrenCount(int groupPosition);

    public abstract VHG onCreateGroupViewHolder(ViewGroup parent, int viewType);

    public abstract VHC onCreateChildViewHolder(ViewGroup parent, int viewType);

    public abstract void onBindGroupViewHolder(VHG holder, int groupPosition);

    public abstract void onBindChildViewHolder(VHC holder, int groupPosition, int childPosition);

    public interface OnGroupItemClickListener {
        void onGroupItemClick(View view, int groupPosition);
    }

    public interface OnGroupItemLongClickListener {
        void onGroupItemLongClick(View view, int groupPosition);
    }

    public interface OnChildItemClickListener {
        void onGroupItemClick(View view, int groupPosition, int childPosition);
    }

    public interface OnChildItemLongClickListener {
        void onGroupItemLongClick(View view, int groupPosition, int childPosition);
    }
}
