package com.example.test;

public interface Callback {
    void onSuccess(Object o);
    void onFailure(Throwable e);
}
