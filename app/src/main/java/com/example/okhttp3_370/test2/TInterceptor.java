package com.example.okhttp3_370.test2;

import java.io.IOException;

import okhttp3.Connection;
import okhttp3.Response;

public interface TInterceptor {
    TResponse intercept(TChain chain) throws IOException;

    interface TChain {
        TRequest request();

        TResponse proceed(TRequest request) throws IOException;

        Connection connection();
    }
}