package com.example.oechappfinal.domain.models

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Onboarding(
    @DrawableRes val imageResId: Int,
    @StringRes val titleTextResId: Int,
    @StringRes val descriptionTextResId: Int
)