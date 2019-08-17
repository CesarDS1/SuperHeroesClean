package com.example.superheroesapp

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration

class PresentationApp : Application() {

    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
        val config = RealmConfiguration.Builder()
            .name(realmDataBaseName)
            .deleteRealmIfMigrationNeeded()
            .build()
        Realm.setDefaultConfiguration(config)
    }

    companion object {
        const val realmDataBaseName = "superheroes.realm"
    }
}