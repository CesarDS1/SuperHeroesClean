package com.example.datalibrary.services

import com.example.domain.model.SuperHero
import com.example.domain.services.SuperHeroServices
import com.example.datalibrary.network.RetrofitServicesInstance
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class SuperHeroServicesImpl : SuperHeroServices {

    override fun getSuperHeroInformation(): Single<List<SuperHero>> {
        return RetrofitServicesInstance.getSuperHeroesApi().getSuperHeroesInformation()
            .map { superHeroListResponse ->
                superHeroListResponse.superheroes.map {
                    SuperHero(
                        it.name,
                        it.photo,
                        it.realName,
                        it.height,
                        it.power,
                        it.abilities,
                        it.groups
                    )
                }
            }.observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io())
    }
}