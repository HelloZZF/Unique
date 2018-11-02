package com.unique.adapter.cell;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.unique.R;
import com.unique.adapter.base.RVBaseAdapter;
import com.unique.adapter.base.RVBaseCell;
import com.unique.adapter.base.RVBaseViewHolder;
import com.unique.adapter.item4_adapter;
import com.unique.adapter.item5_adapter;
import com.unique.bean.Env;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zzf on 2018/9/13.
 */
public class home_item_5 extends RVBaseCell {

    private List<Env> mEnvList = new ArrayList<>();

    public home_item_5() {
        super(null);
    }

    @Override
    public int getItemType() {
        return 5;
    }

    @Override
    public RVBaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType, RVBaseAdapter.OnItemClickListener listener) {
        initData();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_item_5, parent, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycler5);
        recyclerView.setAdapter(new item5_adapter(mEnvList));
        recyclerView.setLayoutManager(new LinearLayoutManager(parent.getContext(), LinearLayoutManager.HORIZONTAL, false));

        return new RVBaseViewHolder(view, listener);
    }

    private void initData() {
        Env env1 = new Env(R.drawable.cell5_1);
        mEnvList.add(env1);
        Env env2 = new Env(R.drawable.cell5_2);
        mEnvList.add(env2);
        Env env3 = new Env(R.drawable.cell5_3);
        mEnvList.add(env3);
        Env env4 = new Env(R.drawable.cell5_4);
        mEnvList.add(env4);
        Env env5 = new Env(R.drawable.cell5_5);
        mEnvList.add(env5);
        Env env6 = new Env(R.drawable.cell5_6);
        mEnvList.add(env6);
        Env env7 = new Env(R.drawable.cell5_7);
        mEnvList.add(env7);
        Env env8 = new Env(R.drawable.cell5_8);
        mEnvList.add(env8);
        Env env9 = new Env(R.drawable.cell5_9);
        mEnvList.add(env9);
        Env env10 = new Env(R.drawable.cell5_10);
        mEnvList.add(env10);
        Env env11 = new Env(R.drawable.cell5_11);
        mEnvList.add(env11);
        Env env12 = new Env(R.drawable.cell5_12);
        mEnvList.add(env12);
        Env env13 = new Env(R.drawable.cell5_13);
        mEnvList.add(env13);
        Env env14 = new Env(R.drawable.cell5_14);
        mEnvList.add(env14);
        Env env15 = new Env(R.drawable.cell5_15);
        mEnvList.add(env15);
        Env env16 = new Env(R.drawable.cell5_16);
        mEnvList.add(env16);
        Env env17 = new Env(R.drawable.cell5_17);
        mEnvList.add(env17);
        Env env18 = new Env(R.drawable.cell5_18);
        mEnvList.add(env18);
        Env env19 = new Env(R.drawable.cell5_19);
        mEnvList.add(env19);
    }

    @Override
    public void onBindViewHolder(RVBaseViewHolder holder, int position) {

    }
}
