package com.example.okhttp3_370.test2;

import java.io.IOException;
import java.util.List;

import okhttp3.Connection;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http.RealInterceptorChain;

public class TRealInterceptorChain implements TInterceptor.TChain {

    private List<TInterceptor> interceptors;
    private StreamAllocation streamAllocation;
    private HttpCodec httpCodec;
    private RealConnection connection;
    private int index;
    private TRequest request;
    private int calls;

    public TRealInterceptorChain(List<TInterceptor> interceptors, StreamAllocation streamAllocation,
                                HttpCodec httpCodec, RealConnection connection, int index, TRequest request) {
        this.interceptors = interceptors;
        this.connection = connection;
        this.streamAllocation = streamAllocation;
        this.httpCodec = httpCodec;
        this.index = index;
        this.request = request;
    }

    @Override
    public TRequest request() {
        return request;
    }

    @Override
    public TResponse proceed(TRequest request) throws IOException {
        TRealInterceptorChain next = new TRealInterceptorChain(
                interceptors, streamAllocation, httpCodec, connection, index + 1, request);
        TInterceptor interceptor = interceptors.get(index);
        TResponse response = interceptor.intercept(next);

        return response;
    }

    @Override
    public Connection connection() {
        return null;
    }
}
