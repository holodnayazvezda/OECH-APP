package com.example.oechappfinal.ui

import com.example.oechappfinal.R


sealed class BottomScreen(
    val route: String,
    val title: String,
    val iconImageId: Int,
    val focusedIconImageId: Int
) {
    data object Home: BottomScreen(
        route = "home",
        title = "Home",
        iconImageId = R.drawable.bottom_home,
        focusedIconImageId = R.drawable.selected_bottom_home
    )
    data object Wallet: BottomScreen(
        route = "wallet",
        title = "Wallet",
        iconImageId = R.drawable.bottom_wallet,
        focusedIconImageId = R.drawable.selected_bottom_wallet
    )
    data object Track: BottomScreen(
        route = "track",
        title = "Track",
        iconImageId = R.drawable.bottom_track,
        focusedIconImageId = R.drawable.selected_bottom_track
    )
    data object Profile: BottomScreen(
        route = "profile",
        title = "Profile",
        iconImageId = R.drawable.bottom_profile,
        focusedIconImageId = R.drawable.selected_bottom_profile
    )
}