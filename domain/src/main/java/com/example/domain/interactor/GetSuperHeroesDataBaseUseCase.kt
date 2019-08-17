package com.example.domain.interactor

import com.example.domain.model.SuperHero
import com.example.domain.repository.ISuperHeroesRepository

class GetSuperHeroesDataBaseUseCase(private val repository: ISuperHeroesRepository) : IGetSuperHeroesDataBaseUseCase {

    override fun invoke(): List<SuperHero> = repository.getRealmSuperHeroInformation()
}