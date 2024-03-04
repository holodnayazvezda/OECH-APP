package com.example.oechappfinal.data.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Onboarding(
    @DrawableRes val imageResId: Int,
    @StringRes val titleTextResId: Int,
    @StringRes val descriptionTextResId: Int
)