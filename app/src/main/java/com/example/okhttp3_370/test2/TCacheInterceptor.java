package com.example.okhttp3_370.test2;

import java.io.IOException;

public class TCacheInterceptor implements TInterceptor {

    public TCacheInterceptor() {
    }

    @Override
    public TResponse intercept(TChain chain) throws IOException {
        TRequest request = chain.request();
        request.setInterceptor3("TCacheInterceptor request");
        TResponse response = chain.proceed(request);
        response.setResponse3("TCacheInterceptor response");
        return response;
    }

}
