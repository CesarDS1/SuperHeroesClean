package com.example.superheroesapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.SuperHero
import com.example.superheroesapp.R
import com.squareup.picasso.Picasso

class SuperHeroesAdapter : RecyclerView.Adapter<SuperHeroesAdapter.SuperHeroesViewHolder>() {

    var superHeroList = mutableListOf<SuperHero>()
    var clickItem: ClickItem? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_super_heroes, parent, false)
        return SuperHeroesViewHolder(view)
    }

    override fun getItemCount() = superHeroList.size

    override fun onBindViewHolder(holder: SuperHeroesViewHolder, position: Int) {
        holder.bind(superHeroList[position])
        holder.itemView.setOnClickListener { clickItem?.onClickItem(superHeroList[position]) }
    }

    class SuperHeroesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val superHeroPhoto: ImageView = itemView.findViewById(R.id.imageView_superhero)
        private val superHeroName: TextView = itemView.findViewById(R.id.textView_name)

        fun bind(superHero: SuperHero) {
            superHeroName.text = superHero.name
            Picasso.get()
                    .load(superHero.photo)
                    .resize(80, 80)
                    .centerCrop()
                    .into(superHeroPhoto)
        }
    }
}