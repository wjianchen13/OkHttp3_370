package com.example.okhttp3_370.test2;

import androidx.annotation.NonNull;

public class TResponse {

    private TRequest request;
    private int code;
    private String message;

    private String response0;
    private String response1;
    private String response2;
    private String response3;
    private String response4;
    private String response5;

    public String getResponse0() {
        return response0;
    }

    public void setResponse0(String response0) {
        this.response0 = response0;
    }

    public String getResponse1() {
        return response1;
    }

    public void setResponse1(String response1) {
        this.response1 = response1;
    }

    public String getResponse2() {
        return response2;
    }

    public void setResponse2(String response2) {
        this.response2 = response2;
    }

    public String getResponse3() {
        return response3;
    }

    public void setResponse3(String response3) {
        this.response3 = response3;
    }

    public String getResponse4() {
        return response4;
    }

    public void setResponse4(String response4) {
        this.response4 = response4;
    }

    public String getResponse5() {
        return response5;
    }

    public void setResponse5(String response5) {
        this.response5 = response5;
    }

    @NonNull
    @Override
    public String toString() {
        return "TRequest { \n"
                + "response0=" + response0 + "\n"
                + "response1=" + response1 + "\n"
                + "response2=" + response2 + "\n"
                + "response3=" + response3 + "\n"
                + "response4=" + response4 + "\n"
                + "response5=" + response5 + "\n";
    }
}
