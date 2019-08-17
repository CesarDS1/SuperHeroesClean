package com.example.superheroesapp.mvp.views

import com.example.superheroesapp.activities.SuperHeroDetailActivity
import com.example.superheroesapp.mvp.model.SuperHeroPresentation
import com.squareup.picasso.Picasso

class HeroDetailView(private val superHeroDetailActivity: SuperHeroDetailActivity) {


    fun showHeroInformation(superHeroPresentation: SuperHeroPresentation) {

        superHeroDetailActivity.nameTv.text = superHeroPresentation.name
        superHeroDetailActivity.realNameTv.text = superHeroPresentation.realName
        superHeroDetailActivity.heightTv.text = superHeroPresentation.height
        superHeroDetailActivity.powerTv.text = superHeroPresentation.power
        superHeroDetailActivity.abilitiesTv.text = superHeroPresentation.abilities
        superHeroDetailActivity.groupsTv.text = superHeroPresentation.groups

        Picasso.get()
                .load(superHeroPresentation.photo)
                .resize(500, 500)
                .centerCrop()
                .into(superHeroDetailActivity.photoIv)
    }
}