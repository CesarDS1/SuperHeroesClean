package com.example.datalibrary.di

import com.example.datalibrary.repository.SuperHeroesDataSourceImpl
import com.example.domain.repository.ISuperHeroesDataSource
import dagger.Binds
import dagger.Module

@Module
internal abstract class DataSourceModule {
    @Binds
    abstract fun superHeroesDataSource(implementation: SuperHeroesDataSourceImpl): ISuperHeroesDataSource
}