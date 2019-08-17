package com.example.superheroesapp.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.datalibrary.repository.SuperHeroesDataSourceImpl
import com.example.datalibrary.repository.SuperHeroesRepositoryImpl
import com.example.datalibrary.services.SuperHeroServicesImpl
import com.example.domain.interactor.GetSuperHeroesDataBaseUseCase
import com.example.domain.interactor.GetSuperHeroesDataUseCase
import com.example.domain.interactor.SaveSuperHeroesUseCase
import com.example.domain.model.SuperHero
import com.example.superheroesapp.R
import com.example.superheroesapp.adapter.ClickItem
import com.example.superheroesapp.mvp.presenters.SuperHeroesPresenter
import com.example.superheroesapp.mvp.views.SuperHeroesView
import kotlinx.android.synthetic.main.activity_main.*

class SuperHeroesActivity : AppCompatActivity(), ClickItem {

    lateinit var recyclerView: RecyclerView
    lateinit var superHeroesPresenter: SuperHeroesPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = recyclewView_superHeroes

        //Init view and presenter
        val superHeroesView = SuperHeroesView(this)
        val superHeroesDataSource = SuperHeroesDataSourceImpl()
        val superHeroesServices = SuperHeroServicesImpl()
        val superHeroesRepository = SuperHeroesRepositoryImpl(superHeroesServices, superHeroesDataSource)
        val getSuperHeroesDataUseCase = GetSuperHeroesDataUseCase(superHeroesRepository)
        val getSuperHeroesDataBaseUseCase = GetSuperHeroesDataBaseUseCase(superHeroesRepository)
        val saveSuperHeroesDataBaseUseCase = SaveSuperHeroesUseCase(superHeroesRepository)

        superHeroesPresenter = SuperHeroesPresenter(
            superHeroesView, getSuperHeroesDataUseCase,
            getSuperHeroesDataBaseUseCase, saveSuperHeroesDataBaseUseCase
        )

        superHeroesPresenter.getSuperHeroesList()
    }

    override fun onClickItem(superHero: SuperHero) {
        superHeroesPresenter.goToDetails(superHero)
    }

}
