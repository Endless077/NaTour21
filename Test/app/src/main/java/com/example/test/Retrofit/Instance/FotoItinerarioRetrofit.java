package com.example.test.Retrofit.Instance;

import com.example.test.Entity.FotoItinerario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface FotoItinerarioRetrofit {

    @GET("listaFotoItinerario")
    Call<List<FotoItinerario>> listFotoItinerario();

    @GET("getFoto/{idFoto}")
    Call<FotoItinerario> getFotoItinerarioByID(@Path("idFoto") Long idFoto);

    @GET("listaFotoItinerario/{idItinerario}")
    Call<List<FotoItinerario>> getFotoItinerarioByItinerario(@Path("idItinerario") Long idItinerario);

    @GET("listaFotoItinerario/count/{idItinerario}")
    Call<Long> getCountFotoItinerario(@Path("idItinerario") Long idItinerario);

    @POST("pubblicaFoto")
    Call<Void> pubblshFoto(@Body FotoItinerario foto);

    @DELETE("eliminaFoto/{idFoto}")
    Call<Void> deleteFoto(@Path("idFoto") Long idFoto);

}
