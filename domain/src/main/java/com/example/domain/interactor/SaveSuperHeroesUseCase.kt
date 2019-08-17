package com.example.domain.interactor

import com.example.domain.model.SuperHero
import com.example.domain.repository.ISuperHeroesRepository

class SaveSuperHeroesUseCase(private val superHeroesRepository: ISuperHeroesRepository) : ISaveSuperHeroesUseCase {

    override fun invoke(superHeroesList: List<SuperHero>) {
        superHeroesRepository.saveSuperHeroInformation(superHeroesList)
    }

}