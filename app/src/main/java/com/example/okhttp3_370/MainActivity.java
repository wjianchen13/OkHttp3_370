package com.example.okhttp3_370;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 使用Okhttp 3.7.0，分析源码
 * 这个例子实现使用Okhttp下载图片，并显示到ImageView上
 */
public class MainActivity extends AppCompatActivity {

    private ImageView imgvTest1;
    private ImageView imgvTest2;
    private String mUrl = "https://img.hayuki.com/upload/room_img/2024-10-09/d0d3726d868377ba04f92aa47d08003c.png?x-image-process=image/resize,w_160,h_160";

    private Handler mHandler = new Handler(Looper.myLooper()) {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch(msg.what) {
                case 1:
                    Bitmap bitmap = (Bitmap)msg.obj;
                    imgvTest1.setImageBitmap(bitmap);
                    break;

                case 2:
                    Bitmap bitmap2 = (Bitmap)msg.obj;
                    imgvTest2.setImageBitmap(bitmap2);
                    break;

            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgvTest1 = findViewById(R.id.imgv_test1);
        imgvTest2 = findViewById(R.id.imgv_test2);
    }

    /**
     * 使用同步方法
     * @param v
     */
    public void onTest1(View v) {
        syncGet(mUrl, new NetWorkCallBack() {
            @Override
            public void onFail(String str) {

            }

            @Override
            public void onRespone(Response response) {
                InputStream input = response.body().byteStream();
                Bitmap bitmap = BitmapFactory.decodeStream(input);
                Message msg = mHandler.obtainMessage();
                msg.what = 1;
                msg.obj = bitmap;
                mHandler.sendMessage(msg);
            }
        });
    }

    /**
     * 同步获取数据
     * @param url
     * @param netWorkCallBack
     */
    private void syncGet(String url, NetWorkCallBack netWorkCallBack) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Response response = client.newCall(request).execute();
                    if(netWorkCallBack != null) {
                        netWorkCallBack.onRespone(response);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    /**
     * 使用异步方法
     * @param v
     */
    public void onTest2(View v) {
        asyncGet(mUrl, new NetWorkCallBack() {
            @Override
            public void onFail(String str) {

            }

            @Override
            public void onRespone(Response response) {
                InputStream input = response.body().byteStream();
                Bitmap bitmap = BitmapFactory.decodeStream(input);
                Message msg = mHandler.obtainMessage();
                msg.what = 2;
                msg.obj = bitmap;
                mHandler.sendMessage(msg);
            }
        });
    }


    /**
     * 异步获取数据
     * @param url
     * @param netWorkCallBack
     */
    private void asyncGet(String url, NetWorkCallBack netWorkCallBack) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                if (netWorkCallBack != null) {
                    netWorkCallBack.onFail("请求失败");
                }
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (netWorkCallBack != null) {
                    netWorkCallBack.onRespone(response);
                }
            }
        });

    }

    public interface NetWorkCallBack {
        void onFail(String str);
        void onRespone(Response response);
    }

}