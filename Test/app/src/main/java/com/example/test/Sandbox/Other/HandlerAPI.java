package com.example.test.Sandbox.Other;

import android.content.Context;
import android.util.Log;

import retrofit2.HttpException;

public class HandlerAPI {

    private Context mContext;
    private Throwable mThrowable;

    //Constructor
    public HandlerAPI(Throwable throwable, Context context) {
        this.mContext = context;
        this.mThrowable = throwable;

        if(throwable instanceof HttpException) {
            HttpException http = (HttpException) throwable;
            String informationService;
            switch (http.code()) {
                case 400:
                    Log.i("TAG", "ERRORE 400");
                    informationService = http.response().headers().get("Information-Service").toString();
                    Log.i("TAG", informationService);
                    break;
                case 404:
                    Log.i("TAG", "ERRORE 404");
                    informationService = http.response().headers().get("Information-Service").toString();
                    Log.i("TAG", informationService);
                    break;
                case 500:
                    Log.i("TAG", "ERRORE 500");
                    Log.i("TAG", "Errore interno del server.");
                    break;
                default:
                    Log.i("TAG", "ERRORE Generico");
                    Log.i("TAG", "Errore generico del server.");
            }
        }
    }

    public HandlerAPI() {}

    //Getter e Setter
    public Throwable getThrowable() {
        return mThrowable;
    }

    public void setThrowable(Throwable throwable) {
        this.mThrowable = throwable;
    }

    public Context getContext() {
        return mContext;
    }

    public void setContext(Context context) {
        this.mContext = context;
    }
}
