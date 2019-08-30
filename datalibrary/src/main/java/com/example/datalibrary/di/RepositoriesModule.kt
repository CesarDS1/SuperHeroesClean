package com.example.datalibrary.di

import com.example.datalibrary.repository.SuperHeroesRepositoryImpl
import com.example.domain.repository.ISuperHeroesRepository
import dagger.Binds
import dagger.Module

@Module
internal abstract class RepositoriesModule {
    @Binds
    abstract fun superHeroesRepository(implementation: SuperHeroesRepositoryImpl): ISuperHeroesRepository
}