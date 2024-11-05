package com.example.okhttp3_370.test2;

import androidx.annotation.NonNull;

import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.RequestBody;

public class TRequest {

    private HttpUrl url;
    private String method;
    private Headers headers;
    private RequestBody body;
    private Object tag;

    private String interceptor0;
    private String interceptor1;
    private String interceptor2;
    private String interceptor3;
    private String interceptor4;
    private String interceptor5;

    public TRequest() {

    }

    public String getInterceptor0() {
        return interceptor0;
    }

    public void setInterceptor0(String interceptor0) {
        this.interceptor0 = interceptor0;
    }

    public String getInterceptor1() {
        return interceptor1;
    }

    public void setInterceptor1(String interceptor1) {
        this.interceptor1 = interceptor1;
    }

    public String getInterceptor2() {
        return interceptor2;
    }

    public void setInterceptor2(String interceptor2) {
        this.interceptor2 = interceptor2;
    }

    public String getInterceptor3() {
        return interceptor3;
    }

    public void setInterceptor3(String interceptor3) {
        this.interceptor3 = interceptor3;
    }

    public String getInterceptor4() {
        return interceptor4;
    }

    public void setInterceptor4(String interceptor4) {
        this.interceptor4 = interceptor4;
    }

    public String getInterceptor5() {
        return interceptor5;
    }

    public void setInterceptor5(String interceptor5) {
        this.interceptor5 = interceptor5;
    }

    @NonNull
    @Override
    public String toString() {
        return "TRequest { \n"
                + "interceptor0=" + interceptor0 + "\n"
                + "interceptor1=" + interceptor1 + "\n"
                + "interceptor2=" + interceptor2 + "\n"
                + "interceptor3=" + interceptor3 + "\n"
                + "interceptor4=" + interceptor4 + "\n"
                + "interceptor5=" + interceptor5 + "\n";
    }
}
