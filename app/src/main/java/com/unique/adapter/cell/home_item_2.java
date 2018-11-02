package com.unique.adapter.cell;

import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.unique.R;
import com.unique.adapter.base.RVBaseAdapter;
import com.unique.adapter.base.RVBaseCell;
import com.unique.adapter.base.RVBaseViewHolder;
import com.unique.widget.ShadowLayout;

/**
 * Created by zzf on 2018/5/14.
 */
public class home_item_2 extends RVBaseCell {


    public home_item_2() {
        super(null);
    }

    @Override
    public int getItemType() {
        return 2;
    }

    @Override
    public RVBaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType, RVBaseAdapter.OnItemClickListener listener) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_item_2, parent, false);
        if (Build.VERSION.SDK_INT >= 25) {

//            ImageView imageView = view.findViewById(R.id.left_image);
//            LinearLayout layout = view.findViewById(R.id.linear_left);
//            imageView.setBackgroundResource(R.drawable.round_image);
//            layout.setBackground(null);
//            layout.setPadding(8,8,3,8);

//            ImageView imageView = new ImageView(parent.getContext());
//            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(imageView.getLayoutParams());
//            lp.setMargins(8, 8, 3, 8);
            //imageView.setBackgroundResource(R.drawable.round_image);
            //imageView.setLayoutParams(lp);
        }

        return new RVBaseViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(RVBaseViewHolder holder, int position) {

    }
}
