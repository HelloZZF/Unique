package com.unique.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

import com.unique.R;
import com.unique.adapter.ViewPagerAdapter;
import com.unique.fragment.CoursesFragment;
import com.unique.fragment.HomeFragment;
import com.unique.fragment.UserFragment;
import com.unique.widget.myViewPager;

public class MainActivity extends BaseActivity {

    private BottomNavigationView mBottomNavigationView;
    private myViewPager viewPager;
    private MenuItem menuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBottomNavigationView = findViewById(R.id.nav_bottom);
        viewPager = findViewById(R.id.viewpager);
        init();
    }

    private void init() {

        initViewPager();
        initBottomNavigationView();
        setStatusbar();

    }

    private void initViewPager() {

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                menuItem = mBottomNavigationView.getMenu().getItem(position);
                menuItem.setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        viewPager.setCanScroll(false);
        setupViewPager(viewPager);

    }

    private void setupViewPager(ViewPager viewPager) {

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(new HomeFragment());
        adapter.addFragment(new CoursesFragment());
        adapter.addFragment(new UserFragment());

        viewPager.setAdapter(adapter);
    }

    private void initBottomNavigationView() {

        mBottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.menu_home_page:
                                viewPager.setCurrentItem(0);
                                break;
                            case R.id.menu_courses:
                                viewPager.setCurrentItem(1);
                                break;
                            case R.id.menu_user:
                                viewPager.setCurrentItem(2);
                                break;
                        }
                        return false;
                    }
                });

    }
}
