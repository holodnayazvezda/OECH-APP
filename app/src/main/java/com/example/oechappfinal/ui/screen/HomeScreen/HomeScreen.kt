package com.example.oechappfinal.ui.screen.HomeScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.oechappfinal.ui.BottomScreen
import com.example.oechappfinal.ui.theme.AppBlue
import com.example.oechappfinal.ui.theme.GreyColor70

@Composable
fun HomeScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomBar(navigator = navController)
        },
        modifier = Modifier.background(Color.White)
    ) {paddingValues ->
        Modifier.padding(top = paddingValues.calculateTopPadding())
        BottomNavGraph(navController = navController)
    }
}

@Composable
fun BottomBar(navigator: NavHostController) {
    val screens = listOf(
        BottomScreen.Home,
        BottomScreen.Wallet,
        BottomScreen.Track,
        BottomScreen.Profile
    )

    val navBackStackEntry by navigator.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    Row(
        Modifier
            .fillMaxWidth()
            .padding(top = 8.dp, bottom = 8.dp)
            .background(Color.White),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        screens.forEach { screen ->
            AddItem(screen = screen, currentDestination = currentDestination, navController = navigator)
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    val selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true
    val spaceColor = if (selected) {AppBlue} else {Color.Transparent}
    val textColor = if (selected) {AppBlue} else {GreyColor70}

    Box(
        modifier = Modifier
            .width(50.dp).height(60.dp)
            .background(Color.White)
            .clickable {
                navController.navigate(screen.route) {
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    launchSingleTop = true
                }
            }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(3.dp)
                    .background(spaceColor)
                    .clip(RoundedCornerShape(30.dp))
            )
            Spacer(modifier = Modifier.padding(3.dp))
            Image(painter = painterResource(
                id = if (selected) {screen.focusedIconImageId} else {screen.iconImageId}),
                contentDescription = null,
                modifier = Modifier.size(25.dp)
            )
            Spacer(modifier = Modifier.padding(2.dp))
            Text(
                text = screen.title,
                color = textColor,
                fontSize = 12.sp
            )
        }
    }
}