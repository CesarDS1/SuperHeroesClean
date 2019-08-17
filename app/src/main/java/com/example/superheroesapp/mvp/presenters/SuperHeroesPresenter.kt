package com.example.superheroesapp.mvp.presenters

import com.example.domain.interactor.GetSuperHeroesDataBaseUseCase
import com.example.domain.interactor.GetSuperHeroesDataUseCase
import com.example.domain.interactor.SaveSuperHeroesUseCase
import com.example.domain.model.SuperHero
import com.example.superheroesapp.mvp.model.SuperHeroPresentation
import com.example.superheroesapp.mvp.views.SuperHeroesView
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable

class SuperHeroesPresenter(
    private val superHeroesView: SuperHeroesView,
    private val getSuperHeroesDataUseCase: GetSuperHeroesDataUseCase,
    private val getSuperHeroesDataBaseUseCase: GetSuperHeroesDataBaseUseCase,
    private val saveSuperHeroesUseCase: SaveSuperHeroesUseCase
) {
    var disposable: Disposable? = null

    fun getSuperHeroesList() {
        getSuperHeroesDataUseCase().subscribe(observerSuperHeroes())
    }

    fun goToDetails(superHero: SuperHero) {
        val superHeroToTransfer = SuperHeroPresentation(
            superHero.name, superHero.photo,
            superHero.realName, superHero.height,
            superHero.power, superHero.abilities, superHero.groups
        )

        superHeroesView.showDetails(superHeroToTransfer)

    }

    private fun observerSuperHeroes(): SingleObserver<List<SuperHero>> {
        return object : SingleObserver<List<SuperHero>> {

            override fun onSubscribe(d: Disposable) {
                disposable = d
            }

            override fun onSuccess(superHeroesList: List<SuperHero>) {
                superHeroesView.showSuperHeroesList(superHeroesList)
                saveSuperHeroesUseCase(superHeroesList)
                disposable?.dispose()

            }

            override fun onError(e: Throwable) {
                superHeroesView.showSuperHeroesList(getSuperHeroesDataBaseUseCase())
            }
        }
    }
}