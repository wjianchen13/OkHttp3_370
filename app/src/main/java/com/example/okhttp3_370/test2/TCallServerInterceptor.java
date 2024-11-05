package com.example.okhttp3_370.test2;

import java.io.IOException;

public class TCallServerInterceptor implements TInterceptor {

    public TCallServerInterceptor() {
    }

    @Override
    public TResponse intercept(TChain chain) throws IOException {
        TRequest request = chain.request();
        request.setInterceptor5("TCallServerInterceptor request");
        TResponse response = getResponse();
        response.setResponse5("TCallServerInterceptor response");
        return response;
    }

    private TResponse getResponse() {
        TResponse response = new TResponse();
        return response;
    }

}
