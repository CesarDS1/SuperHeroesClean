package com.example.superheroesapp.mvp.presenters

import com.example.superheroesapp.mvp.model.SuperHeroPresentation
import com.example.superheroesapp.mvp.views.HeroDetailView
import javax.inject.Inject

class HeroDetailPresenter @Inject constructor(
    private val view: HeroDetailView
) {

    fun setDetails(superHeroPresentation: SuperHeroPresentation) {
        view.showHeroInformation(superHeroPresentation)
    }
}