package com.oussama_chatri.a30daysofrecipes.ui.theme

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Recipe(
    @DrawableRes val photo : Int ,
    @StringRes val name :Int,
    @StringRes val ingredients : Int,
    val number : Int
)
