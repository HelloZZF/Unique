package com.unique.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.text.method.Touch;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Toast;

import com.unique.activity.MainActivity;

/**
 * Created by zzf on 2018/5/18.
 */
public class myRecyclerView extends RecyclerView{

    float x1 = 0;
    float y1 = 0;
    float x2 = 0;
    float y2 = 0;

    public myRecyclerView(Context context) {
        super(context);
    }

    public myRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public myRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //继承了Activity的onTouchEvent方法，直接监听点击事件
//        if(event.getAction() == MotionEvent.ACTION_DOWN) {
//            //当手指按下的时候
//            x1 = event.getX();
//            y1 = event.getY();
//        }
//        if(event.getAction() == MotionEvent.ACTION_UP) {
//            //当手指离开的时候
//            x2 = event.getX();
//            y2 = event.getY();
//            if(y1 - y2 > 50) {
//                Log.d("aaa", "top");
//            } else if(y2 - y1 > 50) {
//                Log.d("aaa", "bottom");
//            } else if(x1 - x2 > 50) {
//                Log.d("aaa", "left");
//            } else if(x2 - x1 > 50) {
//                Log.d("aaa", "right");
//            }
//        }
        return super.onTouchEvent(event);
    }
}
