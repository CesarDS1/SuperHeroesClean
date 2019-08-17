package com.example.domain.interactor

import com.example.domain.model.SuperHero

interface ISaveSuperHeroesUseCase {

    operator fun invoke(superHeroesList: List<SuperHero>)
}