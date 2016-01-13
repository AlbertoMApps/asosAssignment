package com.example.tae_user0.asosassignment.api;

import com.example.tae_user0.asosassignment.Fragments.ProductsByIDFragment;
import com.example.tae_user0.asosassignment.model.modelAPI1.MainModel;
import com.example.tae_user0.asosassignment.model.modelAPI2.ProductsByIDModel;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by TAE_user0 on 22/12/2015.
 */
public interface iProductsByID {
    @GET("/u/1559445/ASOS/SampleApi/anycat_products.json")
    public void getCatalog(@Query("q")String query, Callback<ProductsByIDModel> response);
}
