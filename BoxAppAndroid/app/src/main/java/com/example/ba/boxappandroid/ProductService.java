package com.example.ba.boxappandroid;

/**
 * Created by 2096904 on 12/7/16.
 */

        import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductService
{
    @GET("productos.json")
    Call<List<entidades.Producto>> listTeams();
}