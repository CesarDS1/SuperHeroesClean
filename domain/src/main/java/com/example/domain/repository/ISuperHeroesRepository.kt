package com.example.domain.repository

import com.example.domain.model.SuperHero
import io.reactivex.Single

interface ISuperHeroesRepository {

    fun getSuperHeroInformation(): Single<List<SuperHero>>

    fun getRealmSuperHeroInformation(): List<SuperHero>

    fun saveSuperHeroInformation(superHeroes: List<SuperHero>)
}