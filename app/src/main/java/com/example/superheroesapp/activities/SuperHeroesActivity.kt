package com.example.superheroesapp.activities

import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.SuperHero
import com.example.superheroesapp.R
import com.example.superheroesapp.adapter.ClickItem
import com.example.superheroesapp.mvp.presenters.SuperHeroesPresenter
import dagger.android.AndroidInjection
import dagger.android.DaggerActivity
import javax.inject.Inject

class SuperHeroesActivity : DaggerActivity(), ClickItem {

    lateinit var recyclerView: RecyclerView
    @Inject lateinit var superHeroesPresenter: SuperHeroesPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AndroidInjection.inject(this)
        recyclerView = findViewById(R.id.recyclewView_superHeroes)

        superHeroesPresenter.getSuperHeroesList()
    }

    override fun onClickItem(superHero: SuperHero) {
        superHeroesPresenter.goToDetails(superHero)
    }

}
