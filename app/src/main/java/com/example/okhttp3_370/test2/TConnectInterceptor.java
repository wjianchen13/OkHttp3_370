package com.example.okhttp3_370.test2;

import java.io.IOException;

public class TConnectInterceptor implements TInterceptor {

    public TConnectInterceptor() {
    }

    @Override
    public TResponse intercept(TChain chain) throws IOException {
        TRequest request = chain.request();
        request.setInterceptor4("ConnectInterceptor request");
        TResponse response = chain.proceed(request);
        response.setResponse4("ConnectInterceptor response");
        return response;
    }

}
