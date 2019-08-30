package com.example.domain.interactor

import com.example.domain.model.SuperHero
import com.example.domain.repository.ISuperHeroesRepository
import javax.inject.Inject

class SaveSuperHeroesUseCase @Inject constructor(private val superHeroesRepository: ISuperHeroesRepository) : ISaveSuperHeroesUseCase {

    override fun invoke(superHeroesList: List<SuperHero>) {
        superHeroesRepository.saveSuperHeroInformation(superHeroesList)
    }

}