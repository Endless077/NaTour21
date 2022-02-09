package com.example.test.Retrofit.Instance;

import com.example.test.Entity.FotoItinerario;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface FotoItinerarioRetrofit {

    @GET("listaFotoItinerario")
    Observable<Response<List<FotoItinerario>>> listFotoItinerario();

    @GET("getFoto/{idFoto}")
    Single<Response<FotoItinerario>> getFotoItinerarioByID(@Path("idFoto") Long idFoto);

    @GET("listaFotoItinerario/{idItinerario}")
    Observable<Response<List<FotoItinerario>>> getFotoItinerarioByItinerario(@Path("idItinerario") Long idItinerario);

    @GET("listaFotoItinerario/count/{idItinerario}")
    Single<Long> getCountFotoItinerario(@Path("idItinerario") Long idItinerario);

    @POST("pubblicaFoto")
    Single<Response<Void>> pubblshFoto(@Body FotoItinerario foto);

    @DELETE("eliminaFoto/{idFoto}")
    Single<Response<Void>> deleteFoto(@Path("idFoto") Long idFoto);

}
