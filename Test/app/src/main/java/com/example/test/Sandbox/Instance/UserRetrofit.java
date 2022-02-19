package com.example.test.Sandbox.Instance;

import com.example.test.Entity.Utente;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UserRetrofit {

    @GET("listaUtenti")
    Single<List<Utente>> listUser();

    @GET("getUtente/{username}")
    Single<Utente> getUser(@Path("username") String username);

    @POST("createUtente")
    Single<Response<Void>> postUser(@Body Utente user);

    @DELETE("deleteUtente/{username}")
    Single<Response<Void>> deleteUser(@Path("username") String username);

}
