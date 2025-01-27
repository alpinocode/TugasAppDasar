package com.example.appalpin

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Fruit(
    val nameFruit:String,
    val deskripsiFruit:String,
    val photoFruit:Int
):Parcelable