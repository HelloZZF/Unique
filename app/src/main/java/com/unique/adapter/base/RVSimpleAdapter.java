package com.unique.adapter.base;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.ViewGroup;


/**
 * Created by zhouwei on 17/1/23.
 */

public class RVSimpleAdapter extends RVBaseAdapter {

    public static final int ERROR_TYPE = Integer.MAX_VALUE -1;
    public static final int EMPTY_TYPE = Integer.MAX_VALUE -2;
    public static final int LOADING_TYPE = Integer.MAX_VALUE -3;


    private boolean mIsShowError = false;
    private boolean mIsShowLoading = false;
    private boolean mIsShowEmpty = false;

    public RVSimpleAdapter(){
    }
    @Override
    protected void onViewHolderBound(RVBaseViewHolder holder, int position) {

    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
        //处理GridView 布局
        if(manager instanceof GridLayoutManager){
            final GridLayoutManager gridLayoutManager = (GridLayoutManager) manager;
            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    int viewType = getItemViewType(position);
                    return (viewType == ERROR_TYPE|| viewType == EMPTY_TYPE || viewType == LOADING_TYPE
                    ) ? gridLayoutManager.getSpanCount():1;
                }
            });
        }

    }

    @Override
    public void onViewAttachedToWindow(RecyclerView.ViewHolder holder) {
        // 处理StaggeredGridLayoutManager 显示这个Span
        int position = holder.getAdapterPosition();
        int viewType = getItemViewType(position);
        if(isStaggeredGridLayout(holder)){
            if(viewType == ERROR_TYPE|| viewType == EMPTY_TYPE || viewType == LOADING_TYPE){

                StaggeredGridLayoutManager.LayoutParams params = (StaggeredGridLayoutManager.LayoutParams) holder.itemView.getLayoutParams();
                //设置显示整个span
                params.setFullSpan(true);
            }
        }

    }

    /**
     * 判断是否是瀑布流布局
     * @param holder
     * @return
     */
    private boolean isStaggeredGridLayout(RecyclerView.ViewHolder holder) {
        ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
        if (layoutParams != null && layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
            return true;
        }
        return false;
    }


    @Override
    public void clear() {
        mIsShowError = false;
        mIsShowLoading = false;
        mIsShowEmpty = false;
        super.clear();
    }

}
