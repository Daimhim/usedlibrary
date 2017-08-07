package com.example.demo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.basic.utils.QLog;
import com.example.demo.R;
import com.example.demo.bean.Joke;
import com.example.used.baseadapter.RecyclerAdapterClick;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 项目名称：com.example.demo.adapter
 * 项目版本：usedlibrary
 * 创建人：Daimhim
 * 创建时间：2017/8/7 9:42
 * 修改人：Daimhim
 * 修改时间：2017/8/7 9:42
 * 类描述：
 * 修改备注：
 */

public class TellJokeAdapter extends RecyclerAdapterClick<com.example.demo.adapter.TellJokeAdapter.TellJokeViewHolder> {

    Context mContext;
    List<Joke.ResultBean.DataBean> mJokeList;

    public TellJokeAdapter(Context context) {
        mContext = context;
        mJokeList = new ArrayList<>();
    }

    public void add(Joke.ResultBean.DataBean bean){
        mJokeList.add(bean);
        notifyItemChanged(mJokeList.size());
    }
    public void refresh(List<Joke.ResultBean.DataBean> jokelist){
        mJokeList = jokelist;
        notifyDataSetChanged();
        QLog.i(TAG,"refresh");
    }

    public void addAll(List<Joke.ResultBean.DataBean> jokelist){
        mJokeList.addAll(jokelist);
        notifyDataSetChanged();
    }
    public void clear(){
        mJokeList.clear();
        notifyDataSetChanged();
    }
    @Override
    public TellJokeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TellJokeViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_telljoke, parent, false));
    }

    @Override
    public void onBindViewHolder(TellJokeViewHolder holder, int position) {
        Joke.ResultBean.DataBean dataBean = mJokeList.get(position);
        holder.mTvTitme.setText("更新时间："+ dataBean.getUpdatetime());
        holder.mTvContent.setText(dataBean.getContent());
        QLog.i(TAG,dataBean.getContent());
    }

    @Override
    public int getItemCount() {
        QLog.i(TAG,"getItemCount"+mJokeList.size());
        return mJokeList.size();
    }

    public class TellJokeViewHolder extends RecyclerAdapterClick.BaseViewHolder {

        @BindView(R.id.tv_content)
        TextView mTvContent;
        @BindView(R.id.tv_titme)
        TextView mTvTitme;

        public TellJokeViewHolder(View itemView) {
            super(itemView);
//            R.layout.item_telljoke
            ButterKnife.bind(this,itemView);

        }
    }
}
