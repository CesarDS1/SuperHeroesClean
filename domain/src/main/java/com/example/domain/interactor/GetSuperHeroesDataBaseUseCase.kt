package com.example.domain.interactor

import com.example.domain.model.SuperHero
import com.example.domain.repository.ISuperHeroesRepository
import javax.inject.Inject

class GetSuperHeroesDataBaseUseCase @Inject constructor(private val repository: ISuperHeroesRepository) : IGetSuperHeroesDataBaseUseCase {

    override fun invoke(): List<SuperHero> = repository.getRealmSuperHeroInformation()
}