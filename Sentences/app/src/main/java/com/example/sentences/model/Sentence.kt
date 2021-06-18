package com.example.sentences.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Sentence(
        @StringRes val stringResourceID: Int,
        @DrawableRes val imageResourceId: Int
        ) {

}