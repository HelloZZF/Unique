package com.unique.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.scwang.smartrefresh.header.StoreHouseHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.scwang.smartrefresh.layout.util.DensityUtil;
import com.unique.R;
import com.unique.adapter.base.RVSimpleAdapter;
import com.unique.adapter.cell.home_item_1;
import com.unique.adapter.cell.home_item_2;
import com.unique.adapter.cell.home_item_3;
import com.unique.adapter.cell.home_item_4;
import com.unique.adapter.cell.home_item_5;
import com.unique.widget.myToolbar;

/**
 * Created by zzf on 2018/5/13.
 */
public class HomeFragment extends BaseFragment {

    private myToolbar mToolbar;
    private View mStatus;
    private RecyclerView mRecyclerView;
    private RefreshLayout mRefreshLayout;

    @Override
    public View CreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        mToolbar = view.findViewById(R.id.toolbar);
        mRecyclerView = view.findViewById(R.id.recycler);
        mStatus = view.findViewById(R.id.status);
        mRefreshLayout = view.findViewById(R.id.refreshLayout);

        return view;
    }

    @Override
    public void init() {

        //fitStatusBar(mStatus);
        initRecyclerView();
        initRefreshLayout();
    }

    @SuppressLint("ResourceAsColor")
    private void initRefreshLayout() {

        final int f[] = {0};
        mRefreshLayout.setRefreshFooter(new BallPulseFooter(getContext())
                .setSpinnerStyle(SpinnerStyle.Scale)
                .setNormalColor(0xff48D1CC)
                .setAnimatingColor(0xff48D1CC));

        mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(final RefreshLayout refreshlayout) {

            refreshlayout.finishRefresh(2000/*,false*/);//传入false表示刷新失败

            }
        });


        mRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(final RefreshLayout refreshlayout) {

                refreshlayout.finishLoadMore(2000/*,false*/);//传入false表示加载失败
                f[0] = f[0] +1;
                if (f[0] >= 2)
                    Toast.makeText(getContext(), "我是有底线的", Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void initRecyclerView() {

        RVSimpleAdapter adapter = new RVSimpleAdapter();
        adapter.add(new home_item_1());
        adapter.add(new home_item_2());
        adapter.add(new home_item_3());
        adapter.add(new home_item_5());
        adapter.add(new home_item_4(getContext()));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(adapter);
    }
}
