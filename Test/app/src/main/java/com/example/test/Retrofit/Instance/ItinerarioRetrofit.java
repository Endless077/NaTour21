package com.example.test.Retrofit.Instance;

import com.example.test.Entity.Itinerario;
import com.example.test.Entity.SearchFilter;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ItinerarioRetrofit {

    @GET("listaItinerari")
    Call<List<Itinerario>> listItinerari();

    @GET("listaItinerari/orderByRecent")
    Call<List<Itinerario>> getAllRecent();

    @GET("listaItinerari/ByName/{nomeItinerario}")
    Call<List<Itinerario>> getItinerariByName(@Path("nomeItinerario") String nomeItinerario);

    @GET("getItinerario/byID/{idItinerario}")
    Call<Itinerario> getItinerarioByID(@Path("idItinerario") Long idItinerario);

    @GET("getItinerario/byUsername/{username}")
    Call<List<Itinerario>> getItinerarioByUsername(@Path("username") String username);

    @GET("getItinerario/byFilter")
    Call<List<Itinerario>> getItinerarioByFilter(@Body SearchFilter filtro);

    @POST("createItinerario")
    Call<Void> createItinerario(@Body Itinerario itinerario);

    @PUT("modifyItinerario")
    Call<Void> modifyCompilation(@Body Itinerario itinerario);

    @DELETE("deleteItinerario/{id_itinerario}")
    Call<Void> removeItinerario(@Path("id_itinerario") long id_itinerario);

}
