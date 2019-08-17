package com.example.domain.interactor

import com.example.domain.model.SuperHero

interface IGetSuperHeroesDataBaseUseCase {
    
    operator fun invoke(): List<SuperHero>
}