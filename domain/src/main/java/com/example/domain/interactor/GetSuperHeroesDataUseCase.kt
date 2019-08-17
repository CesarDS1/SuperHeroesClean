package com.example.domain.interactor

import com.example.domain.model.SuperHero
import com.example.domain.repository.ISuperHeroesRepository
import com.example.domain.services.SuperHeroServices
import io.reactivex.Single

class GetSuperHeroesDataUseCase(private val superHeroesRepository: ISuperHeroesRepository) : IGetSuperHeroesDataUseCase {

    override fun invoke(): Single<List<SuperHero>> {
        return superHeroesRepository.getSuperHeroInformation()
    }
}