package com.example.datalibrary.repository

import com.example.datalibrary.realm.SuperHeroeEntity
import com.example.domain.model.SuperHero
import com.example.domain.repository.ISuperHeroesDataSource
import io.realm.Realm

class SuperHeroesDataSourceImpl : ISuperHeroesDataSource {

    override fun getSuperHeroes(): List<SuperHero> {
        val realm = Realm.getDefaultInstance()
        val listSuperHeroes = mutableListOf<SuperHero>()
        realm.use { realm ->
            val superHeroesRealmResult = realm.where(SuperHeroeEntity::class.java).findAll()
            superHeroesRealmResult.forEach {
                listSuperHeroes.add(
                    SuperHero(
                        it.name,
                        it.photo,
                        it.realName,
                        it.height,
                        it.power,
                        it.abilities,
                        it.groups
                    )
                )
            }
        }
        return listSuperHeroes
    }

    override fun saveSuperHeroes(listHeroes: List<SuperHero>) {
        val realm = Realm.getDefaultInstance()
        realm.use { realm ->
            realm.executeTransaction {
                listHeroes.forEach {
                    realm.copyToRealmOrUpdate(
                        SuperHeroeEntity(
                            it.name,
                            it.photo,
                            it.realName,
                            it.height,
                            it.power,
                            it.abilities,
                            it.groups
                        )
                    )
                }
            }
        }
    }
}
