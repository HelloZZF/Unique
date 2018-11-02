package com.unique.fragment;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.unique.R;
import com.unique.utile.FastBlurUtil;

/**
 * Created by zzf on 2018/5/13.
 */
public class UserFragment extends BaseFragment{

    private ImageView mUserbg;
    private View mStatus;

    @Override
    public View CreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user, container, false);
        mUserbg = view.findViewById(R.id.user_bg);
        mStatus = view.findViewById(R.id.user_StatusbarView);
        return view;
    }

    @Override
    public void init() {

        BlurImage();
        fitStatusBar(mStatus);
    }

    private void BlurImage() {
        //背景图片虚化
        Resources res = getResources();
        Bitmap scaledBitmap = BitmapFactory.decodeResource(res, R.drawable.user_icon);
        Bitmap blurBitmap = FastBlurUtil.toBlur(scaledBitmap, 2, 8);
        mUserbg.setScaleType(ImageView.ScaleType.CENTER_CROP);
        mUserbg.setImageBitmap(blurBitmap);
    }
}
