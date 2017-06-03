package com.example.daimhim.baseadapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * @version $Rev
 * @time 2017/4/25 9:41
 * @updateAuthor $Author
 * @updateDate 2017/4/25
 * @updateDes ${TODO}
 * <p>
 * Created by Daimhim on 2017/4/25.
 */
public abstract class RecyclerAdapterClick<VH extends RecyclerAdapterClick.BaseViewHolder> extends RecyclerView.Adapter<VH> {
    private OnItemClickListener mOnItemClickListeners;
    private OnItemLongClickListener mOnItemLongClickListener;

    /**
     * 提供给外部的 接口  传入此接口 监听点击事件
     */
    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public interface OnItemLongClickListener {
        void onItemLongClick(View view, int position);
    }

    /**
     * 点击事件发生时调用 子类Adapter可以重写该方法 实现自定义点击事件
     *
     * @param v                 被点击的View
     * @param position          被电击View的位置
     * @param itemClickListener 用户设置的监听
     */
    protected void onItemClickListener(View v, int position, OnItemClickListener itemClickListener) {
        if (null != itemClickListener) {
            itemClickListener.onItemClick(v, position);
        }
    }

    protected void onItemLongClickListener(View v, int position, OnItemLongClickListener itemLongClickListener) {
        if (null != itemLongClickListener) {
            itemLongClickListener.onItemLongClick(v, position);
        }
    }

    /**
     * 用于开启点击事件
     *
     * @return
     */
    protected boolean isOnItemClickListener() {
        return false;
    }

    protected boolean isOnItemLongClickListener() {
        return false;
    }

    public class BaseViewHolder extends RecyclerView.ViewHolder {
        private View.OnClickListener mOnHolderClickListene = null;
        private View.OnLongClickListener mOnHolderLongClickListener = null;

        public BaseViewHolder(View itemView) {
            super(itemView);
            if (null != mOnItemClickListeners || isOnItemClickListener()) {
                mOnHolderClickListene = new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onItemClickListener(v, getLayoutPosition(), getOnItemClickListener());
                    }
                };
            }
            if (null != mOnItemLongClickListener || isOnItemLongClickListener()) {
                mOnHolderLongClickListener = new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        onItemLongClickListener(v, getLayoutPosition(), getOnItemLongClickListener());
                        return true;
                    }
                };
            }
        }

        public View.OnClickListener getOnHolderClickListene() {
            return mOnHolderClickListene;
        }

        public View.OnLongClickListener getOnHolderLongClickListener() {
            return mOnHolderLongClickListener;
        }
    }

    //设置点击监听
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListeners = onItemClickListener;
    }

    //设置点击监听
    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        mOnItemLongClickListener = onItemLongClickListener;
    }

    /**
     * 返回点击监听
     *
     * @return
     */
    public OnItemLongClickListener getOnItemLongClickListener() {
        return mOnItemLongClickListener;
    }

    /**
     * 返回点击监听
     *
     * @return
     */
    public OnItemClickListener getOnItemClickListener() {
        return mOnItemClickListeners;
    }

}
