package com.example.test.Retrofit.Instance;

import com.example.test.Entity.InterestingPoint;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface InterestingPointRetrofit {

    @GET("listaInterestingPoint")
    Call<List<InterestingPoint>> listInterestingPoint();

    @GET("getInterestingPoint/byID/{idInterestingPoint}")
    Call<InterestingPoint> getCompilationByID(@Path("idInterestingPoint") long idInterestingPoint);

    @GET("getInterestingPoint/byItinerario/{idItinerario}")
    Call<List<InterestingPoint>> getInterestingPointByItinerario(@Path("idItinerario") long idItinerario);

    @GET("getInterestingPoint/getSingleFoto/{idInterestingPoint}")
    Call<String> getFotoItinerarioSingle(@Path("idInterestingPoint") long idInterestingPoint);

    @GET("getInterestingPoint/getMultipleFoto/{idInterestingPoint}")
    Call<List<String>> getFotoItinerarioMultiple(@Path("idItinerario") long idItinerario);

    @POST("createInterestingPoint")
    Call<Void> createCompilation(@Body InterestingPoint interestingPoint);

    @PUT("modifyInterestingPoint")
    Call<Void> modifyCompilation(@Body InterestingPoint interestingPoint);

    @DELETE("deleteInterestingPoint/{idInterestingPoint}")
    Call<Void> deleteInterestingPoint(@Path("idInterestingPoint") long idInterestingPoint);

    @DELETE("deleteInterestingPoint/foto/{idInterestingPoint}")
    Call<Void> deleteFotoInterestingPoint(@Path("idInterestingPoint") long idInterestingPoint);

}
