package com.example.test.Retrofit.Instance;

import com.example.test.Entity.Tappa;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface TappaRetrofit {

    @GET("listaTappe")
    Observable<Response<List<Tappa>>> listTappe();

    @GET("getTappa/ByID/{idTappa}")
    Single<Response<Tappa>> getTappaByID(@Path("idTappa") Long idTappa);

    @GET("getComplation/byItinerario/{idItinerario}")
    Observable<Response<List<Tappa>>> getTappaByItinerario(@Path("idItinerario") Long idItinerario);

    @POST("createTappa")
    Single<Response<Void>> createTappa(@Body Tappa tappa);

    @POST("createTappe")
    Single<Response<Void>> createTappe(@Body Tappa tappe);

}
