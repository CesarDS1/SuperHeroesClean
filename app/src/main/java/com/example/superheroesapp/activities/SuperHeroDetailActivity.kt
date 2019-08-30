package com.example.superheroesapp.activities

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.superheroesapp.R
import com.example.superheroesapp.mvp.model.SuperHeroPresentation
import com.example.superheroesapp.mvp.presenters.HeroDetailPresenter
import com.example.superheroesapp.mvp.views.HeroDetailView
import dagger.android.AndroidInjection
import dagger.android.DaggerActivity
import kotlinx.android.synthetic.main.activity_super_hero_detail.*

class SuperHeroDetailActivity : DaggerActivity() {

    lateinit var photoIv: ImageView
    lateinit var nameTv: TextView
    lateinit var realNameTv: TextView
    lateinit var heightTv: TextView
    lateinit var powerTv: TextView
    lateinit var abilitiesTv: TextView
    lateinit var groupsTv: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_super_hero_detail)
        photoIv = imageView_photo
        nameTv = textView_name
        realNameTv = textView_real_name
        heightTv = textView_height
        powerTv = textView_power
        abilitiesTv = textView_abilities
        groupsTv = textView_groups

        val data = intent.extras

        val superHeroPresentation = data?.getParcelable<SuperHeroPresentation>("superhero")
        val heroDetailView = HeroDetailView(this)
        val heroDetailPresenter = HeroDetailPresenter(heroDetailView)

        superHeroPresentation?.let {
            heroDetailPresenter.setDetails(it)
        } ?: heroDetailPresenter.setDetails(
                SuperHeroPresentation(
                        "Not found", "Not found", "Not found",
                        "Not found", "Not found", "Not found", "Not found"
                )
        )

    }
}
