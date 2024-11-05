package com.example.okhttp3_370;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.okhttp3_370.test1.TestActivity1;
import com.example.okhttp3_370.test2.TestActivity2;

/**
 * 使用Okhttp 3.7.0，分析源码
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * OkHttp 基础测试
     * @param v
     */
    public void onTest1(View v) {
        startActivity(new Intent(this, TestActivity1.class));
    }

    /**
     * 责任链
     * @param v
     */
    public void onTest2(View v) {
        startActivity(new Intent(this, TestActivity2.class));
    }


}