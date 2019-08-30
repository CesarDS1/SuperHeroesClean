package com.example.domain.interactor

import com.example.domain.model.SuperHero
import com.example.domain.repository.ISuperHeroesRepository
import com.example.domain.services.SuperHeroServices
import io.reactivex.Single
import javax.inject.Inject

class GetSuperHeroesDataUseCase @Inject constructor(private val superHeroesRepository: ISuperHeroesRepository)
    : IGetSuperHeroesDataUseCase {

    override fun invoke(): Single<List<SuperHero>> {
        return superHeroesRepository.getSuperHeroInformation()
    }
}