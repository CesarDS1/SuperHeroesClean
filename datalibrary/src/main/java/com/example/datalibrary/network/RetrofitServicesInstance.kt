package com.example.datalibrary.network

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitServicesInstance {

    private const val baseUrl = "https://api.myjson.com/"

    fun getSuperHeroesApi(): SuperHeroesApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(SuperHeroesApi::class.java)
    }
}