package com.example.tae_user0.asosassignment.api;

import com.example.tae_user0.asosassignment.model.modelAPI1.MainModel;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by TAE_user0 on 19/12/2015.
 */
public interface iMensCats {
    @GET("/u/1559445/ASOS/SampleApi/cats_men.json")
    public void getCats(Callback<MainModel> response);
}
