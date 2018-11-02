package com.unique.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.unique.R;

public class WelComeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        setStatusbar();
        //欢迎页会在数据加载结束后自动消失
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        Intent intent = new Intent(WelComeActivity.this, MainActivity.class);
//                        startActivity(intent);
//                        WelComeActivity.this.finish();
//                    }
//                });
//            }
//        }).start();

        //欢迎页会在2s之后消失
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(WelComeActivity.this, MainActivity.class);
                startActivity(intent);
                WelComeActivity.this.finish();
            }
        }, 2000);
    }
}
