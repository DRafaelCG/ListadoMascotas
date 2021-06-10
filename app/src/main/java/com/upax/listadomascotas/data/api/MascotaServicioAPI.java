package com.upax.listadomascotas.data.api;

import com.upax.listadomascotas.data.model.Mascota;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface MascotaServicioAPI {
    @GET("breeds?x-api-key=")
    Call<List<Mascota>> getMascotas(@Query("API_KEY") String apiKey);
}
