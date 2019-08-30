package com.example.datalibrary.repository

import com.example.datalibrary.services.SuperHeroServicesImpl
import com.example.domain.model.SuperHero
import com.example.domain.repository.ISuperHeroesRepository
import javax.inject.Inject

class SuperHeroesRepositoryImpl @Inject constructor(
    private val servicesImpl: SuperHeroServicesImpl,
    private val dataSource: SuperHeroesDataSourceImpl
) : ISuperHeroesRepository {

    override fun getSuperHeroInformation() = servicesImpl.getSuperHeroInformation()

    override fun getRealmSuperHeroInformation() = dataSource.getSuperHeroes()

    override fun saveSuperHeroInformation(superHeroes: List<SuperHero>) =
        dataSource.saveSuperHeroes(superHeroes)


}