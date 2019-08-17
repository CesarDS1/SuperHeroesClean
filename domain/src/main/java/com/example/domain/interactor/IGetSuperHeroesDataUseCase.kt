package com.example.domain.interactor

import com.example.domain.model.SuperHero
import io.reactivex.Single

interface IGetSuperHeroesDataUseCase {
    operator fun invoke(): Single<List<SuperHero>>
}