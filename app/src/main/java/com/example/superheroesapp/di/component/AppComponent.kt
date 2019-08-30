package com.example.superheroesapp.di.component

import android.app.Application
import com.example.datalibrary.di.DataModule
import com.example.domain.di.DomainModule
import com.example.superheroesapp.PresentationApp
import com.example.superheroesapp.di.module.ActivityModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector


@Component(
    modules = [AndroidInjectionModule::class, DataModule::class, ActivityModule::class, DomainModule::class]
)
interface AppComponent : AndroidInjector<PresentationApp> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    override fun inject(app: PresentationApp)

}