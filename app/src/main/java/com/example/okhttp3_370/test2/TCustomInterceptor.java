package com.example.okhttp3_370.test2;

import java.io.IOException;

public class TCustomInterceptor implements TInterceptor {

    public TCustomInterceptor() {
    }

    @Override
    public TResponse intercept(TChain chain) throws IOException {
        TRequest request = chain.request();
        request.setInterceptor0("TCustomInterceptor request");
        TResponse response = chain.proceed(request);
        response.setResponse0("TCustomInterceptor response");
        return response;
    }

}
