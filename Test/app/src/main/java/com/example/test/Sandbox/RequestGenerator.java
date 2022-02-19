package com.example.test.Sandbox;

import com.example.test.Sandbox.Enumeration.API;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RequestGenerator {

    public static String CURRENT_URL = null;
    public static Retrofit retrofit = null;

    private RequestGenerator() {}

    public static Retrofit retrofitInstance(API api) {
        String URL = "http://192.168.1.53:8080";
        String URL_BODY = getApiType(api);
        String NEW_URL = URL + URL_BODY;

        if(CURRENT_URL == null || !CURRENT_URL.equals(NEW_URL)) {
            CURRENT_URL = NEW_URL;
            retrofit = new Retrofit.Builder()
                    .baseUrl(NEW_URL)
                    .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    private static String getApiType(API api) {
        switch (api) {
            case FOTO_ITINERARIO:
                return "/api/fotoItinerario/";
            case INTERESTINGPOINT_API:
                return "/api/interestingpoint/";
            case TAPPA_API:
                return "/api/tappa/";
            case ITINERARIO_API:
                return "/api/itinerario/";
            case COMPILATION_API:
                return "/api/compilation/";
            case SERVER_API:
                return "/";
            case USER_API:
                return "/api/user/";
            default:
                return "/api/undefinited/";
        }
    }

}
