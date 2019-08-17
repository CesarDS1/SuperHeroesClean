package com.example.superheroesapp.adapter

import com.example.domain.model.SuperHero

interface ClickItem {
    fun onClickItem(superHero: SuperHero)
}