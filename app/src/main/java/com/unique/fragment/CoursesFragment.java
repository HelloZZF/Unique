package com.unique.fragment;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.unique.R;
import com.unique.adapter.base.RVSimpleAdapter;
import com.unique.adapter.cell.teacher_cell;
import com.unique.bean.Teacher;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zzf on 2018/5/13.
 */
public class CoursesFragment extends BaseFragment {

    private TabLayout mTabLayout;
    private RecyclerView mRecyclerView;
    private RefreshLayout mRefreshLayout;
    private RVSimpleAdapter mAdapter;
    private List<Teacher> mTeachers = new ArrayList<>();
    private Handler mHandler;
    private int type = 0;

    @Override
    public View CreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_courses, container, false);
        mTabLayout = view.findViewById(R.id.courses_tablayout);
        mRecyclerView = view.findViewById(R.id.recycler);
        mRefreshLayout = view.findViewById(R.id.refreshLayout);
        mHandler = new Handler();
        return view;
    }

    @Override
    public void init() {

        initTabLayout();
        initRecyclerView();
        initRefreshLayout();
    }

    private void initRecyclerView() {

        mAdapter = new RVSimpleAdapter();
        initData(0);
        for (int i = 0; i < mTeachers.size(); i++) {

            mAdapter.add(new teacher_cell(mTeachers, getContext()));
        }
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void initData(int type) {

        switch (type) {

            case 0:

                mTeachers.add(new Teacher(R.drawable.t1, "Kelly", "北大研究生，对java有深入探究","5/19 8:00-10:00"));
                mTeachers.add(new Teacher(R.drawable.t2, "Addison", "5年高校讲师，丰富的教学经验","5/22 9:00-11:00"));
                mTeachers.add(new Teacher(R.drawable.t3, "Tommy", "幽默风趣的教学风格","5/16 7:00-9:00"));
                mTeachers.add(new Teacher(R.drawable.t4, "Easter", "百度前架构师，实战水平一流","5/09 18:00-20:00"));
                mTeachers.add(new Teacher(R.drawable.t5, "Fred", "严谨的教学风格，认真对待每一件事","5/18 8:30-10:30"));
                mTeachers.add(new Teacher(R.drawable.t6, "Ryan", "新颖的教学方式，深受学生喜爱","5/27 20:20-22:20"));
                type = 0;
                break;
            case 1:

                mTeachers.add(new Teacher(R.drawable.t11, "Benson", "对爬虫方面有深入研究","5/01 20:20-22:20"));
                mTeachers.add(new Teacher(R.drawable.t12, "Wesley", "全栈工程师，全方面教学","5/27 7:00-9:00"));
                mTeachers.add(new Teacher(R.drawable.t13, "Randy", "笔记达人，带你梳理知识点","5/18 9:40-11:40"));
                mTeachers.add(new Teacher(R.drawable.t14, "Carl", "喜欢跟孩子们互动，活跃气氛","5/29 15:20-17:20"));
                mTeachers.add(new Teacher(R.drawable.t15, "Peter", "精通多门编程语言","5/31 8:30-10:30"));
                mTeachers.add(new Teacher(R.drawable.t16, "Jason", "热爱答疑，对学生负责","5/15 18:10-20:10"));
                type = 1;
                break;
            case 2:

                mTeachers.add(new Teacher(R.drawable.t21, "Marian", "多年从业经验，项目开发经验","5/15 18:10-20:10"));
                mTeachers.add(new Teacher(R.drawable.t22, "Aidan", "跟孩子互动是我最大的乐趣","5/25 19:20-21:30"));
                mTeachers.add(new Teacher(R.drawable.t24, "Aaron", "前腾讯工程师，专业水平","5/07 7:00-9:00"));
                mTeachers.add(new Teacher(R.drawable.t18, "Harriet", "最求极简的代码风格","5/11 19:20-21:30"));
                mTeachers.add(new Teacher(R.drawable.t2, "Addison", "5年高校讲师，丰富的教学经验","5/22 9:00-11:00"));
                mTeachers.add(new Teacher(R.drawable.t3, "Tommy", "幽默风趣的教学风格","5/16 7:00-9:00"));
                type = 2;
                break;
            case 3:

                mTeachers.add(new Teacher(R.drawable.t16, "Jason", "热爱答疑，对学生负责","5/15 18:10-20:10"));
                mTeachers.add(new Teacher(R.drawable.t17, "Alonso", "多年教学经验，博学多才","5/28 16:40-18:40"));
                mTeachers.add(new Teacher(R.drawable.t10, "Eve", "热爱踩坑和填坑","5/08 16:40-18:40"));
                mTeachers.add(new Teacher(R.drawable.t23, "Irene", "风趣的教学风格","5/29 18:20-20:20"));
                mTeachers.add(new Teacher(R.drawable.t4, "Easter", "百度前架构师，实战水平一流","5/09 18:00-20:00"));
                mTeachers.add(new Teacher(R.drawable.t23, "Irene", "风趣的教学风格","5/29 18:20-20:20"));
                type = 3;
                break;
            case 4:

                mTeachers.add(new Teacher(R.drawable.t18, "Harriet", "最求极简的代码风格","5/11 19:20-21:30"));
                mTeachers.add(new Teacher(R.drawable.t19, "Irene", "引入国外先进的教学体系","5/05 7:30-10:30"));
                mTeachers.add(new Teacher(R.drawable.t20, "Tina", "热衷于解决bug","5/08 10:00-11:30"));
                mTeachers.add(new Teacher(R.drawable.t15, "Peter", "精通多门编程语言","5/31 8:30-10:30"));
                mTeachers.add(new Teacher(R.drawable.t10, "Eve", "热爱踩坑和填坑","5/08 16:40-18:40"));
                mTeachers.add(new Teacher(R.drawable.t12, "Wesley", "全栈工程师，全方面教学","5/27 7:00-9:00"));
                type = 4;
                break;
            default:
                break;


        }


    }




    private void initTabLayout() {

        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                List<teacher_cell> cells = mAdapter.getData();

                for (int i = 0; i < cells.size(); i++) {

                    cells.get(i).startAnimator();
                }

                switch (tab.getPosition()) {

                    case 0:
                        changeData(0);
                        break;
                    case 1:
                        changeData(1);
                        break;
                    case 2:
                        changeData(2);
                        break;
                    case 3:
                        changeData(3);
                        break;
                    case 4:
                        changeData(4);
                        break;
                }



            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    private void changeData(int type){

        mTeachers.clear();
        initData(type);
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mAdapter.clear();
                for (int i = 0; i < mTeachers.size(); i++) {

                    mAdapter.add(new teacher_cell(mTeachers, getContext()));
                }
            }
        }, 400);
        mRecyclerView.scrollToPosition(0);
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
            public void onRefresh(RefreshLayout refreshlayout) {
                refreshlayout.finishRefresh(2000/*,false*/);//传入false表示刷新失败
            }
        });
        mRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshlayout) {
                if (mTeachers.size() < 10) {
                    addData(type);
                    mAdapter.clear();
                    for (int i = 0; i < mTeachers.size(); i++) {

                        mAdapter.add(new teacher_cell(mTeachers, getContext()));
                    }
                }else if (mTeachers.size() == 10) {
                    f[0] = f[0] +1;
                    if (f[0] >= 2)
                        Toast.makeText(getContext(), "我是有底线的", Toast.LENGTH_SHORT).show();
                }

                refreshlayout.finishLoadMore(2000/*,false*/);//传入false表示加载失败
            }
        });
    }

    private void addData(int type) {

        switch (type) {

            case 0:

                mTeachers.add(new Teacher(R.drawable.t7, "Kylie", "有丰富的项目经验","5/30 9:40-11:40"));
                mTeachers.add(new Teacher(R.drawable.t8, "Kelly", "活泼生动的课堂气氛","5/16 18:20-20:20"));
                mTeachers.add(new Teacher(R.drawable.t9, "Leon", "对新技术执着探索","5/04 17:00-19:30"));
                mTeachers.add(new Teacher(R.drawable.t10, "Eve", "热爱踩坑和填坑","5/08 16:40-18:40"));
                break;
            case 1:

                mTeachers.add(new Teacher(R.drawable.t17, "Alonso", "多年教学经验，博学多才","5/28 16:40-18:40"));
                mTeachers.add(new Teacher(R.drawable.t18, "Harriet", "最求极简的代码风格","5/11 19:20-21:30"));
                mTeachers.add(new Teacher(R.drawable.t19, "Irene", "引入国外先进的教学体系","5/05 7:30-10:30"));
                mTeachers.add(new Teacher(R.drawable.t20, "Tina", "热衷于解决bug","5/08 10:00-11:30"));
                break;
            case 2:

                mTeachers.add(new Teacher(R.drawable.t14, "Carl", "喜欢跟孩子们互动，活跃气氛","5/29 15:20-17:20"));
                mTeachers.add(new Teacher(R.drawable.t15, "Peter", "精通多门编程语言","5/31 8:30-10:30"));
                mTeachers.add(new Teacher(R.drawable.t19, "Irene", "引入国外先进的教学体系","5/05 7:30-10:30"));
                mTeachers.add(new Teacher(R.drawable.t23, "Irene", "风趣的教学风格","5/29 18:20-20:20"));
                break;
            case 3:

                mTeachers.add(new Teacher(R.drawable.t24, "Aaron", "前腾讯工程师，专业水平","5/07 7:00-9:00"));
                mTeachers.add(new Teacher(R.drawable.t18, "Harriet", "最求极简的代码风格","5/11 19:20-21:30"));
                mTeachers.add(new Teacher(R.drawable.t15, "Peter", "精通多门编程语言","5/31 8:30-10:30"));
                mTeachers.add(new Teacher(R.drawable.t14, "Carl", "喜欢跟孩子们互动，活跃气氛","5/29 15:20-17:20"));
                break;
            case 4:

                mTeachers.add(new Teacher(R.drawable.t11, "Benson", "对爬虫方面有深入研究","5/01 20:20-22:20"));
                mTeachers.add(new Teacher(R.drawable.t13, "Randy", "笔记达人，带你梳理知识点","5/18 9:40-11:40"));
                mTeachers.add(new Teacher(R.drawable.t21, "Marian", "多年从业经验，项目开发经验","5/15 18:10-20:10"));
                mTeachers.add(new Teacher(R.drawable.t22, "Aidan", "跟孩子互动是我最大的乐趣","5/25 19:20-21:30"));
                break;
            default:
                break;


        }


    }


}
