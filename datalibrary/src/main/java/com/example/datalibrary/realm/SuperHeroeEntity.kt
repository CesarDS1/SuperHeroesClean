package com.example.datalibrary.realm

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class SuperHeroeEntity(
    @PrimaryKey var name: String = "", var photo: String = "",
    var realName: String = "", var height: String = "",
    var power: String = "", var abilities: String = "", var groups: String = ""
) : RealmObject()