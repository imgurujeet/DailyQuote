package com.imgurujeet.quoteapp.presentation.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.imgurujeet.quoteapp.data.Category
import com.imgurujeet.quoteapp.presentation.explore.ExploreScreen
import com.imgurujeet.quoteapp.presentation.home.HomeScreen
import com.imgurujeet.quoteapp.presentation.saved.SavedScreen

@Composable
fun AppNavigation(navController: NavHostController,modifier: Modifier = Modifier) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            BottomNavBar(navController)
        }
    ) { innerPadding ->

        NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {
            composable(Screen.HomeScreen.route) {
                HomeScreen(navController, modifier = Modifier.padding(innerPadding))
            }
            composable("${ Screen.ExploreScreen.route }?category={category}",
                arguments = listOf(
                    navArgument("category") {
                        type = NavType.StringType
                        nullable = true
                    }
                )

            ) {
                val category = it.arguments?.getString("category")
                val selectedCategory = category?.let { Category.valueOf(it) }

                ExploreScreen(navController, modifier = Modifier.padding(innerPadding),selectedCategory)
            }
            composable(Screen.SavedScreen.route) {
                SavedScreen(navController, modifier = Modifier.padding(innerPadding))
            }

        }

    }


}