package com.example.demo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.used.baseadapter.ExpandableRecyclerAdapter;
import com.example.used.baseadapter.RecyclerAdapterClick;

import java.util.List;

/**
 * 项目名称：com.example.demo
 * 项目版本：usedlibrary
 * 创建人：Daimhim
 * 创建时间：2017/6/10 12:36
 * 修改人：Daimhim
 * 修改时间：2017/6/10 12:36
 * 类描述：
 * 修改备注：
 */

class DemoAdapter extends ExpandableRecyclerAdapter<DemoAdapter.DemoGroupHolder,DemoAdapter.DemoChildHolder> {
    private Context mContext;
    private List<Pair<String, List<String>>> mStringListPair;
    public DemoAdapter(Context context, List<Pair<String, List<String>>> data) {
        mContext = context;
        mStringListPair = data;
        notifyPositionChanged();
    }

    public void remove(int groupPosition){
        notifyItemRangeRemoved(groupPosition,getChildrenCount(groupPosition));
        mStringListPair.remove(groupPosition);
        notifyGroupPositionChanged(groupPosition);
    }
    public void addGroup(int groupPosition,Pair<String, List<String>> pair){
        mStringListPair.add(groupPosition,pair);
        notifyItemRangeInserted(groupPosition,pair.second.size());
        notifyGroupPositionChanged(groupPosition);
    }
    @Override
    public int getGroupCount() {
        return mStringListPair.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return mStringListPair.get(groupPosition).second.size();
    }

    @Override
    public DemoGroupHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        return new DemoGroupHolder(LayoutInflater.from(mContext).inflate(R.layout.item_adapter_layout,parent,false));
    }

    @Override
    public DemoChildHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        return new DemoChildHolder(LayoutInflater.from(mContext).inflate(R.layout.item_adapter_layout,parent,false));
    }

    @Override
    public void onBindGroupViewHolder(DemoGroupHolder holder, int groupPosition) {
        holder.mTextView.setTextSize(TypedValue.COMPLEX_UNIT_DIP,18);
        holder.mTextView.setGravity(Gravity.CENTER);
        holder.mTextView.setText(mStringListPair.get(groupPosition).first);
        holder.mTextView.setOnClickListener(holder.getOnHolderClickListene());
    }

    @Override
    public void onBindChildViewHolder(DemoChildHolder holder, int groupPosition, int childPosition) {
        holder.mTextView.setTextSize(TypedValue.COMPLEX_UNIT_DIP,16);
        holder.mTextView.setGravity(Gravity.LEFT);
        holder.mTextView.setText(mStringListPair.get(groupPosition).second.get(childPosition));
        holder.mTextView.setOnClickListener(holder.getOnHolderClickListene());
    }

    class DemoGroupHolder extends RecyclerAdapterClick.BaseViewHolder{
        TextView mTextView;
        public DemoGroupHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.tv_content);
        }
    }

    class DemoChildHolder extends RecyclerAdapterClick.BaseViewHolder{
        TextView mTextView;
        public DemoChildHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.tv_content);
        }
    }
}
