package com.example.domain.repository

import com.example.domain.model.SuperHero

interface ISuperHeroesDataSource {
    fun getSuperHeroes(): List<SuperHero>
    fun saveSuperHeroes(listHeroes: List<SuperHero>)
}