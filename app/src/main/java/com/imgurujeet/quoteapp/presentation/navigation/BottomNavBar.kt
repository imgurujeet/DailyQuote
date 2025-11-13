package com.imgurujeet.quoteapp.presentation.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.savedstate.savedState

@Composable
fun BottomNavBar(navHost: NavHostController){

    val items = listOf(
        Screen.HomeScreen,
        Screen.ExploreScreen,
        Screen.SavedScreen
    )

    val navBackStackEntry by navHost.currentBackStackEntryAsState()
    val currentRole = navBackStackEntry?.destination?.route


    NavigationBar {
        items.forEach { screen ->
            NavigationBarItem(
                icon = {
                    screen.icon?.let {
                        Icon(imageVector = it, contentDescription = null)
                    }

                },
                label = {
                    Text(text = screen.title)
                },
                selected = currentRole == screen.route,
                onClick = {
                    if (currentRole != screen.route) {
                        navHost.navigate(screen.route){
                            popUpTo(navHost.graph.startDestinationId){
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true

                        }

                    }
                }

            )


        }

    }

}