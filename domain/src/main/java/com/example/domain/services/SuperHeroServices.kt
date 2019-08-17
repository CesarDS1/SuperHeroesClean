package com.example.domain.services

import com.example.domain.model.SuperHero
import io.reactivex.Single

interface SuperHeroServices {
    fun getSuperHeroInformation(): Single<List<SuperHero>>
}