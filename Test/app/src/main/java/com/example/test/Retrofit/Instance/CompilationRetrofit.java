package com.example.test.Retrofit.Instance;

import com.example.test.Entity.Compilation;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface CompilationRetrofit {

    @GET("listaCompilation")
    Call<List<Compilation>> listCompilation();

    @GET("getCompilation/byID/{idCollection}")
    Call<Compilation> getCompilationByID(@Path("idCollection") long username);

    @GET("getComplation/byUsername/{username}")
    Call<List<Compilation>> getCompilationByUsername(@Path("username") String username);

    @GET("getComplation/itinerari/{idCompilation}")
    Call<List<String>> getCompilationByUsername(@Path("idCompilation") long idCompilation);

    @POST("compilation/createCompilation")
    Call<Void> postCompilation(@Body Compilation compilation);

    @POST("addItinerario/{idCompilation}/{idItinerario}")
    Call<Void> postItinerarioInCompilation(@Path("idCompilation") long idCompilation,
                                           @Path("idItinerario") long idItinerario);

    @PUT("modifyCompilation")
    Call<Void> putCompilation(@Body Compilation compilation);

    @DELETE("deleteCompilation/{idCompilation}")
    Call<Void> deleteCompilation(@Path("idCompilation") long idCompilation);

    @DELETE("removeItinerario/{idCompilation}/{idItinerario}")
    Call<Void> deleteItinerarioInCompilation(@Path("idCompilation") long idCompilation,
                                             @Path("idItinerario") long idItinerario);

}
