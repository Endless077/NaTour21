package com.example.test.Retrofit.Instance;

import com.example.test.Entity.Tappa;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface TappaRetrofit {

    @GET("listaTappe")
    Call<List<Tappa>> listTappe();

    @GET("getTappa/ByID/{idTappa}")
    Call<Tappa> getTappaByID(@Path("idTappa") Long idTappa);

    @GET("getComplation/byItinerario/{idItinerario}")
    Call<List<Tappa>> getTappaByItinerario(@Path("idItinerario") Long idItinerario);

    @POST("createTappa")
    Call<Void> createTappa(@Body Tappa tappa);

    @POST("createTappe")
    Call<Void> createTappe(@Body Tappa tappe);

}
