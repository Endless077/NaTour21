package com.example.test.Sandbox.Instance;

import io.reactivex.rxjava3.core.Completable;
import retrofit2.http.GET;

public interface ServerUtils {

    @GET("/health")
    Completable getServiceStatus();

}
