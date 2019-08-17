package com.example.superheroesapp.mvp.model


import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SuperHeroPresentation(
    var name: String, var photo: String,
    var realName: String, var height: String,
    var power: String, var abilities: String, var groups: String
) : Parcelable
