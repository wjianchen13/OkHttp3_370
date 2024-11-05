package com.example.okhttp3_370.test2;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.okhttp3_370.R;
import com.example.okhttp3_370.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.Response;
import okhttp3.internal.cache.CacheInterceptor;
import okhttp3.internal.connection.ConnectInterceptor;
import okhttp3.internal.http.BridgeInterceptor;
import okhttp3.internal.http.CallServerInterceptor;
import okhttp3.internal.http.RealInterceptorChain;

/**
 * 责任链
 */
public class TestActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);
    }

    /**
     *
     * @param v
     */
    public void onTest1(View v) {
        try {
            TResponse tResponse = getResponseWithInterceptorChain();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private TResponse getResponseWithInterceptorChain() throws IOException {
        // Build a full stack of interceptors.
        List<TInterceptor> customInterceptors = getCustomInterceptors();
        List<TInterceptor> interceptors = new ArrayList<>();
        interceptors.addAll(customInterceptors);
        interceptors.add(new TRetryAndFollowUpInterceptor());
        interceptors.add(new TBridgeInterceptor());
        interceptors.add(new TCacheInterceptor());
        interceptors.add(new TConnectInterceptor());

        interceptors.add(new TCallServerInterceptor());

        TRequest originalRequest = new TRequest();
        TInterceptor.TChain chain = new TRealInterceptorChain(
                interceptors, null, null, null, 0, originalRequest);
        TResponse tResponse = chain.proceed(originalRequest);
        Utils.log("originalRequest: " + originalRequest);
        Utils.log("tResponse: " + tResponse);
        return tResponse;
    }

    private List<TInterceptor> getCustomInterceptors() {
        List<TInterceptor> interceptors = new ArrayList<>();
        interceptors.add(new TCustomInterceptor());
        return interceptors;
    }


}