package com.example.superheroesapp.di.module

import com.example.superheroesapp.activities.SuperHeroDetailActivity
import com.example.superheroesapp.activities.SuperHeroesActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun contributesSuperHeroesActivity(): SuperHeroesActivity

    @ContributesAndroidInjector
    abstract fun contributesSuperHeroDetailActivity(): SuperHeroDetailActivity

}