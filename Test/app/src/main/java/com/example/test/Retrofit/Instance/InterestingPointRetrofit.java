package com.example.test.Retrofit.Instance;

import com.example.test.Entity.InterestingPoint;

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

public interface InterestingPointRetrofit {

    @GET("listaInterestingPoint")
    Observable<Response<List<InterestingPoint>>> listInterestingPoint();

    @GET("getInterestingPoint/byID/{idInterestingPoint}")
    Single<Response<InterestingPoint>> getCompilationByID(@Path("idInterestingPoint") long idInterestingPoint);

    @GET("getInterestingPoint/byItinerario/{idItinerario}")
    Observable<Response<List<InterestingPoint>>> getInterestingPointByItinerario(@Path("idItinerario") long idItinerario);

    @GET("getInterestingPoint/getSingleFoto/{idInterestingPoint}")
    Single<String> getFotoItinerarioSingle(@Path("idInterestingPoint") long idInterestingPoint);

    @GET("getInterestingPoint/getMultipleFoto/{idInterestingPoint}")
    Observable<Response<List<String>>> getFotoItinerarioMultiple(@Path("idItinerario") long idItinerario);

    @POST("createInterestingPoint")
    Single<Response<Void>> createCompilation(@Body InterestingPoint interestingPoint);

    @PUT("modifyInterestingPoint")
    Single<Response<Void>> modifyCompilation(@Body InterestingPoint interestingPoint);

    @DELETE("deleteInterestingPoint/{idInterestingPoint}")
    Single<Response<Void>> deleteInterestingPoint(@Path("idInterestingPoint") long idInterestingPoint);

    @DELETE("deleteInterestingPoint/foto/{idInterestingPoint}")
    Single<Response<Void>> deleteFotoInterestingPoint(@Path("idInterestingPoint") long idInterestingPoint);

}
