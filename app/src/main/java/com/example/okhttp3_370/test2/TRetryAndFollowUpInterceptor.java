package com.example.okhttp3_370.test2;


import java.io.IOException;

public class TRetryAndFollowUpInterceptor implements TInterceptor {

    public TRetryAndFollowUpInterceptor() {
    }

    @Override
    public TResponse intercept(TChain chain) throws IOException {
        TRequest request = chain.request();
        request.setInterceptor1("TRetryAndFollowUpInterceptor request");
        TResponse response = chain.proceed(request);
        response.setResponse1("TRetryAndFollowUpInterceptor response");
        return response;
    }

}
