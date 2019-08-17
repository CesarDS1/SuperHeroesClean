package com.example.datalibrary.network

import com.example.datalibrary.model.SuperHeroListResponse
import io.reactivex.Single
import retrofit2.http.GET

interface SuperHeroesApi {
    @GET("bins/bvyob")
    fun getSuperHeroesInformation(): Single<SuperHeroListResponse>
}