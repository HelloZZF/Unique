package com.unique.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by zzf on 2018/5/17.
 */
public class myViewPager extends ViewPager {

    public boolean isCanScroll=true;

    public myViewPager(Context context) {
        this(context,null);
    }

    public myViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setCanScroll(boolean isCanScroll){
        this.isCanScroll=isCanScroll;
    }
    //禁止滑动
    //第一种
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if(!isCanScroll){
            return false;
        }
        return super.onTouchEvent(ev);
    }
    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        if(!isCanScroll){
            return false;
        }
        return super.onInterceptTouchEvent(event);
    }
//    第二种
//    @Override
//    public void scrollTo(int x, int y) {
//        if(isCanScroll){
//            super.scrollTo(x, y);
//        }
//    }

    //去除页面切换时的滑动翻页效果//可以直接设置
//    @Override
//    public void setCurrentItem(int item, boolean smoothScroll) {
//        // TODO Auto-generated method stub
//        super.setCurrentItem(item, smoothScroll);
//    }
//
//    @Override
//    public void setCurrentItem(int item) {
//        // TODO Auto-generated method stub
//        super.setCurrentItem(item, false);
//    }
}

