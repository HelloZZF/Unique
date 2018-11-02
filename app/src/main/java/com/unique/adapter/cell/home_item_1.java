package com.unique.adapter.cell;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.unique.R;
import com.unique.adapter.base.RVBaseAdapter;
import com.unique.adapter.base.RVBaseCell;
import com.unique.adapter.base.RVBaseViewHolder;
import com.zhouwei.mzbanner.MZBannerView;
import com.zhouwei.mzbanner.holder.MZHolderCreator;
import com.zhouwei.mzbanner.holder.MZViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zzf on 2018/5/13.
 */
public class home_item_1 extends RVBaseCell {

    private Context mContext;

    public home_item_1() {
        super(null);
    }

    @Override
    public int getItemType() {
        return 1;
    }

    @Override
    public RVBaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType, RVBaseAdapter.OnItemClickListener listener) {

        mContext = parent.getContext();
        View view = LayoutInflater.from(mContext).inflate(R.layout.home_item_1, parent, false);

        return new RVBaseViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(RVBaseViewHolder holder, int position) {

        List<Integer> list = new ArrayList<>();
        list.add(R.drawable.banner2);
        list.add(R.drawable.banner1);
        list.add(R.drawable.banner3);

        MZBannerView bannerView = (MZBannerView) holder.getView(R.id.banner);

        bannerView.setPages(list, new MZHolderCreator<BannerViewHolder>() {
            @Override
            public BannerViewHolder createViewHolder() {
                return new BannerViewHolder();
            }
        });
        bannerView.setIndicatorVisible(false);
        bannerView.start();
    }

   public static class BannerViewHolder implements MZViewHolder<Integer> {
        private ImageView mImageView;
        @Override
        public View createView(Context context) {
            // 返回页面布局
            View view = LayoutInflater.from(context).inflate(R.layout.banner_item,null);
            mImageView = view.findViewById(R.id.banner_image);
            return view;
        }

        @Override
        public void onBind(Context context, int position, Integer data) {
            // 数据绑定
            mImageView.setImageResource(data);
        }
    }
}
