package com.example.tae_user0.asosassignment.api;

import com.example.tae_user0.asosassignment.model.modelAPI2.ProductsByIDModel;
import com.example.tae_user0.asosassignment.model.modelAPI3.ProductDetailsModel;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by TAE_user0 on 30/12/2015.
 */
public interface iProductDetail {
    @GET("/u/1559445/ASOS/SampleApi/anyproduct_details.json")
    public void getProductDetail(@Query("q")String query, Callback<ProductDetailsModel> response);

}
