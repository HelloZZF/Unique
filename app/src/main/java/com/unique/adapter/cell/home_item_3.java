package com.unique.adapter.cell;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.unique.R;
import com.unique.adapter.base.RVBaseAdapter;
import com.unique.adapter.base.RVBaseCell;
import com.unique.adapter.base.RVBaseViewHolder;

/**
 * Created by zzf on 2018/5/14.
 */
public class home_item_3 extends RVBaseCell {


    public home_item_3() {
        super(null);
    }

    @Override
    public int getItemType() {
        return 3;
    }

    @Override
    public RVBaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType, RVBaseAdapter.OnItemClickListener listener) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_item_3, parent, false);

        return new RVBaseViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(RVBaseViewHolder holder, int position) {

    }
}
