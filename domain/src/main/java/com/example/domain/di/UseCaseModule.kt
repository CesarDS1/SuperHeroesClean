package com.example.domain.di

import com.example.domain.interactor.*
import dagger.Binds
import dagger.Module

@Module
internal abstract class UseCaseModule {

    @Binds
    abstract fun getSuperHeroesDataUseCase(implementation: GetSuperHeroesDataUseCase): IGetSuperHeroesDataUseCase

    @Binds
    abstract fun getSuperHeroesDataBaseUseCase(implementation: GetSuperHeroesDataBaseUseCase): IGetSuperHeroesDataBaseUseCase

    @Binds
    abstract fun saveSuperHeroesUseCase(implementation: SaveSuperHeroesUseCase): ISaveSuperHeroesUseCase

}