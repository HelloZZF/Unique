package com.unique.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.TintTypedArray;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.unique.R;

import java.lang.reflect.Field;

/**
 * Created by admin on 2017/11/11.
 */

public class myToolbar extends Toolbar {

    private LayoutInflater mInflater;

    private View mView;
    private TextView mTextTitle;
    private SearchView homeSearView;
    private SearchView classifySearView;
    private ImageButton mRightButton;
    private ImageButton mLeftButton;
    private TabLayout mTabLayout;


    public myToolbar(Context context) {
        this(context, null);
    }

    public myToolbar(Context context, @Nullable AttributeSet attrs) {
        this(context,attrs,0);
    }

    @SuppressLint("RestrictedApi")
    public myToolbar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);


        initView();
        setContentInsetsRelative(10,10);

        if (attrs != null){
            final TintTypedArray a = TintTypedArray.obtainStyledAttributes(getContext(),attrs, R.styleable.myToolbar,defStyleAttr,0);
            final Drawable rightIcon = a.getDrawable(R.styleable.myToolbar_rightButtonIcon);
            if (rightIcon != null) {
                setRightButtonIcon(rightIcon);
            }

            final Drawable leftIcon = a.getDrawable(R.styleable.myToolbar_leftButtonIcon);
            if (leftIcon != null) {
                setLeftButtonIcon(leftIcon);
            }

            boolean isShowHomeSearchView = a.getBoolean(R.styleable.myToolbar_isShowHomeSearchView, false);
            boolean isShowClassifySearchView = a.getBoolean(R.styleable.myToolbar_isShowClassifySearchView, false);
            boolean isShowTabLayout = a.getBoolean(R.styleable.myToolbar_isShowTabLayout,false);

            if (isShowHomeSearchView) {
                showHomeSearchView();
                hideTitleView();
            }

            if (isShowClassifySearchView) {
                showClassifySearchView();
                hideTitleView();
            }

            if (isShowTabLayout) {
                showTabLayout();
            }

            a.recycle();
        }

    }

    private void initView() {

        if (mView == null) {

            mInflater = LayoutInflater.from(getContext());
            mView = mInflater.inflate(R.layout.my_toolbar, null);

            mTextTitle = mView.findViewById(R.id.toolbar_title);
            homeSearView = mView.findViewById(R.id.home_searchView);
            classifySearView = mView.findViewById(R.id.classify_searchView);
            mRightButton = mView.findViewById(R.id.toolbar_rightButton);
            mLeftButton = mView.findViewById(R.id.toolbar_leftButton);
            mTabLayout = mView.findViewById(R.id.courses_tablayout);

            LayoutParams lp = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.CENTER_HORIZONTAL);
            addView(mView, lp);

        }


    }

    public ImageButton getRightButton(){
        return mRightButton;
    }

    public void setRightButtonIcon(Drawable icon){

        if (mRightButton != null) {
            mRightButton.setImageDrawable(icon);
            mRightButton.setVisibility(VISIBLE);
        }
    }

    public void setRightButtonIcon(int icon){

        if (mRightButton != null) {
            mRightButton.setImageResource(icon);
            mRightButton.setVisibility(VISIBLE);
        }
    }

    public void setRightButtonOnClickListener(OnClickListener li){

        mRightButton.setOnClickListener(li);

    }

    public ImageButton getLeftButton(){
        return mLeftButton;
    }

    public void setLeftButtonIcon(Drawable icon){

        if (mLeftButton != null) {
            mLeftButton.setImageDrawable(icon);
            mLeftButton.setVisibility(VISIBLE);
        }
    }

    public void setLeftButtonIcon(int icon){

        if (mLeftButton != null) {
            mLeftButton.setImageResource(icon);
            mLeftButton.setVisibility(VISIBLE);
        }
    }

    public void setLeftButtonOnClickListener(OnClickListener li){

        mLeftButton.setOnClickListener(li);

    }

    @Override
    public void setTitle(int resId) {
        setTitle(getContext().getText(resId));
    }

    @Override
    public void setTitle(CharSequence title) {

        initView();
        mTextTitle.setText(title);
        showTitleView();
    }

    public TabLayout getTabLayout() {

        return mTabLayout;
    }

    public void showHomeSearchView(){
        if (homeSearView != null) {

            setSearchView(homeSearView);
            homeSearView.setVisibility(VISIBLE);
        }
    }

    public void hideHomeSearchView(){
        if (homeSearView != null)
            homeSearView.setVisibility(GONE);
    }

    public void showTabLayout(){
        if (mTabLayout != null)
            mTabLayout.setVisibility(VISIBLE);
    }

    public void hideTabLayout(){
        if (mTabLayout != null)
            mTabLayout.setVisibility(GONE);
    }

    public void showClassifySearchView(){
        if (classifySearView != null) {
            setSearchView(classifySearView);
            classifySearView.setVisibility(VISIBLE);
        }
    }

    public void hideClassifySearchView(){
        if (classifySearView != null)
            classifySearView.setVisibility(GONE);
    }

    public void showTitleView(){
        if (mTextTitle != null)
            mTextTitle.setVisibility(VISIBLE);
    }

    public void hideTitleView(){
        if (mTextTitle != null)
            mTextTitle.setVisibility(GONE);
    }

    public SearchView getHomeSearView(){
        return homeSearView;
    }

    public SearchView getClassifySearView(){
        return classifySearView;
    }

    public boolean isShowTabLayout() {

        if (mTabLayout.getVisibility() == VISIBLE)
            return true;
        return false;
    }

    private void setSearchView(SearchView searView) {

        TextView textView = (TextView) searView.findViewById(android.support.v7.appcompat.R.id.search_src_text);
        textView.setHintTextColor(Color.parseColor("#80ffffff"));

        //去掉searchview下划线 方法二
        try {        //--拿到字节码
            Class<?> argClass = searView.getClass();
            //--指定某个私有属性,mSearchPlate是搜索框父布局的名字
            Field ownField = argClass.getDeclaredField("mSearchPlate");
            //--暴力反射,只有暴力反射才能拿到私有属性
            ownField.setAccessible(true);
            View mView = (View) ownField.get(searView);
            //--设置背景
            mView.setBackgroundColor(Color.TRANSPARENT);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

//    public void showRightButton(){
//        if (mRightButton != null)
//            mRightButton.setVisibility(VISIBLE);
//    }
//
//    public void hideRightButton(){
//        if (mRightButton != null)
//            mRightButton.setVisibility(GONE);
//    }
//
//    public void showLeftButton(){
//        if (mLeftButton != null)
//            mLeftButton.setVisibility(VISIBLE);
//    }
//
//    public void hideLeftButton(){
//        if (mLeftButton != null)
//            mLeftButton.setVisibility(GONE);
//    }
}
