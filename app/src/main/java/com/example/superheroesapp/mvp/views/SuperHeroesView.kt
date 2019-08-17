package com.example.superheroesapp.mvp.views

import android.content.Intent
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.domain.model.SuperHero
import com.example.superheroesapp.activities.SuperHeroDetailActivity
import com.example.superheroesapp.activities.SuperHeroesActivity
import com.example.superheroesapp.adapter.ClickItem
import com.example.superheroesapp.adapter.SuperHeroesAdapter
import com.example.superheroesapp.mvp.model.SuperHeroPresentation

class SuperHeroesView(private val superHeroesActivity: SuperHeroesActivity) {

    var superHeroesAdapter = SuperHeroesAdapter()

    init {
        superHeroesActivity.recyclerView.adapter = superHeroesAdapter
        superHeroesActivity.recyclerView.layoutManager = LinearLayoutManager(superHeroesActivity)
    }

    fun showSuperHeroesList(superHeroesList: List<SuperHero>) {
        superHeroesAdapter.superHeroList = superHeroesList.toMutableList()
        superHeroesAdapter.clickItem = superHeroesActivity
        superHeroesAdapter.notifyDataSetChanged()
    }

    fun showDetails(superHeroPresentation: SuperHeroPresentation) {
        val intent = Intent(superHeroesActivity, SuperHeroDetailActivity::class.java)
        intent.putExtra(HERO_KEY, superHeroPresentation)
        superHeroesActivity.startActivity(intent)
    }
    companion object{
        const val HERO_KEY = "superhero"
    }

}