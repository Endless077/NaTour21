package com.example.test.Retrofit.Instance;

import com.example.test.Entity.Utente;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UserRetrofit {

    @GET("listaUtenti")
    Call<List<Utente>> listUser();

    @GET("getUtente/{username}")
    Call<Utente> getUser(@Path("username") String username);

    @POST("createUtente")
    Call<Void> postUser(@Body Utente user);

    @DELETE("deleteUtente/{username}")
    Call<Void> deleteUser(@Path("username") String username);

}
