package com.example.datalibrary.di

import com.example.datalibrary.services.SuperHeroServicesImpl
import com.example.domain.services.SuperHeroServices
import dagger.Binds
import dagger.Module

@Module
internal abstract class ServicesModule {

    @Binds
    abstract fun superHeroesServices(implementation: SuperHeroServicesImpl): SuperHeroServices
}