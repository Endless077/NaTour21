package com.example.test.Retrofit.Instance;

import com.example.test.Entity.Itinerario;
import com.example.test.Entity.SearchFilter;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ItinerarioRetrofit {

    @GET("listaItinerari")
    Observable<Response<List<Itinerario>>> listItinerari();

    @GET("listaItinerari/orderByRecent")
    Observable<Response<List<Itinerario>>> getAllRecent();

    @GET("listaItinerari/ByName/{nomeItinerario}")
    Observable<Response<List<Itinerario>>> getItinerariByName(@Path("nomeItinerario") String nomeItinerario);

    @GET("getItinerario/byID/{idItinerario}")
    Single<Response<Itinerario>> getItinerarioByID(@Path("idItinerario") Long idItinerario);

    @GET("getItinerario/byUsername/{username}")
    Observable<Response<List<Itinerario>>> getItinerarioByUsername(@Path("username") String username);

    @GET("getItinerario/byFilter")
    Observable<Response<List<Itinerario>>> getItinerarioByFilter(@Body SearchFilter filtro);

    @POST("createItinerario")
    Single<Response<Void>> createItinerario(@Body Itinerario itinerario);

    @PUT("modifyItinerario")
    Single<Response<Void>> modifyCompilation(@Body Itinerario itinerario);

    @DELETE("deleteItinerario/{id_itinerario}")
    Single<Response<Void>> removeItinerario(@Path("id_itinerario") long id_itinerario);

}
