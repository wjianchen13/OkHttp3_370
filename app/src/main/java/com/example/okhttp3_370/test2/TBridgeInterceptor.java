package com.example.okhttp3_370.test2;

import java.io.IOException;

public class TBridgeInterceptor implements TInterceptor {

    public TBridgeInterceptor() {
    }

    @Override
    public TResponse intercept(TChain chain) throws IOException {
        TRequest request = chain.request();
        request.setInterceptor2("TBridgeInterceptor request");
        TResponse response = chain.proceed(request);
        response.setResponse2("TBridgeInterceptor response");
        return response;
    }

}
