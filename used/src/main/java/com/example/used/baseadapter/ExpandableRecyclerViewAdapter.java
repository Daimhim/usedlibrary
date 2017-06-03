package com.example.used.baseadapter;

import android.util.Pair;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/4 0004.
 */

public abstract class ExpandableRecyclerViewAdapter<VHG extends RecyclerAdapterClick.BaseViewHolder,VHC extends RecyclerAdapterClick.BaseViewHolder> extends RecyclerAdapterClick<RecyclerAdapterClick.BaseViewHolder> {

    private List<Pair<Integer, Integer>> mPairPositionList;

    private int mPosition = -1;

    public final void notifyPositionChanged(){
        if (null == mPairPositionList){
            mPairPositionList = new ArrayList<>();
        }else {
            mPairPositionList.clear();
        }
        for (int i = 0; i < getGroupCount(); i++) {
            mPairPositionList.add(new Pair<>(i, -1));
            for (int j = 0; j < getChildrenCount(i); j++) {
                mPairPositionList.add(new Pair<>(i, j));
            }
        }
    }

    @Override
    public RecyclerAdapterClick.BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Pair<Integer, Integer> integerPair = mPairPositionList.get(mPosition);
        if (integerPair.second == -1) {
            return onCreateGroupViewHolder(parent,viewType);
        } else {
            return onCreateChildViewHolder(parent, viewType);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerAdapterClick.BaseViewHolder holder, int position) {
        Pair<Integer, Integer> integerPair = mPairPositionList.get(position);
        if (integerPair.second == -1){
            onBindGroupViewHolder((VHG) holder,integerPair.first);
        }else {
            onBindChildViewHolder((VHC) holder,integerPair.first,integerPair.second);
        }
    }

    @Override
    public int getItemViewType(int position) {
        mPosition = position;
        Pair<Integer, Integer> integerPair = mPairPositionList.get(position);
        if (integerPair.second == -1) {
            return -(getGroupItemViewType(integerPair.first) == 0 ? -1 : getGroupItemViewType(integerPair.first));
        } else {
            return Math.abs(getChildItemViewType(integerPair.first,integerPair.second));
        }
    }

    @Override
    public int getItemCount() {
        return mPairPositionList.size();
    }

    public int getGroupItemViewType(int groupPosition){
        return 1;
    }

    public int getChildItemViewType(int groupPosition,int childPosition){
        return 1;
    }
    //如果为Group 则返回-1 为子类则返回 其位置
    public int getPosition(int position){
        return mPairPositionList.get(position).second;
    }

    /**
     * 获取当前坐标
     * @param position
     * @return
     */
    public Pair<Integer, Integer> getCoordinate(int position){
        return mPairPositionList.get(position);
    }
    public abstract int getGroupCount();

    public abstract int getChildrenCount(int groupPosition);

    public abstract VHG onCreateGroupViewHolder(ViewGroup parent, int viewType);

    public abstract VHC onCreateChildViewHolder(ViewGroup parent, int viewType);

    public abstract void onBindGroupViewHolder(VHG holder, int groupPosition);

    public abstract void onBindChildViewHolder(VHC holder,int groupPosition, int childPosition);

}
