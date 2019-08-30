package com.example.datalibrary.di

import dagger.Module

@Module(includes = [RepositoriesModule::class, DataSourceModule::class, ServicesModule::class])
class DataModule