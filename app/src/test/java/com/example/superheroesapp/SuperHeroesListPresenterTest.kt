package com.example.superheroesapp

import com.example.domain.interactor.GetSuperHeroesDataBaseUseCase
import com.example.domain.interactor.GetSuperHeroesDataUseCase
import com.example.domain.interactor.SaveSuperHeroesUseCase
import com.example.domain.model.SuperHero
import com.example.superheroesapp.mvp.presenters.SuperHeroesPresenter
import com.example.superheroesapp.mvp.views.SuperHeroesView
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations


class SuperHeroesListPresenterTest {

    private lateinit var superHeroesPresenter: SuperHeroesPresenter
    @Mock lateinit var superHeroesView: SuperHeroesView
    @Mock lateinit var superHeroesDataUseCase: GetSuperHeroesDataUseCase
    @Mock lateinit var getSuperHeroesDataBaseUseCase: GetSuperHeroesDataBaseUseCase
    @Mock lateinit var saveSuperHeroesDataUseCase: SaveSuperHeroesUseCase

    @Before
    fun init() {
        MockitoAnnotations.initMocks(this)

        superHeroesPresenter = SuperHeroesPresenter(
            superHeroesView, superHeroesDataUseCase,
            getSuperHeroesDataBaseUseCase, saveSuperHeroesDataUseCase
        )
    }

    @Test
    fun testGetSuperHeroesList() {

        whenever(superHeroesDataUseCase.invoke()).thenReturn(Single.just(superHeroesMockList))

        val test = superHeroesDataUseCase.invoke().test()

        superHeroesPresenter.getSuperHeroesList()

        test.assertValue(superHeroesMockList).assertNoErrors()
    }

    @Test
    fun testGetSuperHeroesEmptyList() {
        whenever(superHeroesDataUseCase.invoke()).thenReturn(Single.just(emptyList()))

        val test = superHeroesDataUseCase.invoke().test()

        superHeroesPresenter.getSuperHeroesList()
        test.assertValue(emptyList()).assertNoErrors()
    }

    @Test
    fun testGoToDetails() {
        superHeroesPresenter.goToDetails(superHeroMock)

        verify(superHeroesView).showDetails(any())
    }

    private val superHeroMock = SuperHero(
        "Android", "Android", "Android", "Android",
        "Android", "Android", "Android"
    )

    private val superHeroesMockList: List<SuperHero> = mutableListOf(superHeroMock, superHeroMock, superHeroMock)


}