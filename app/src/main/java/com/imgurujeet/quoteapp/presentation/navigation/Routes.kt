package com.imgurujeet.quoteapp.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String, val title: String, val icon: ImageVector ? = null) {
    object HomeScreen : Screen(route = "home","Home", Icons.Filled.Home)
    object ExploreScreen : Screen(route = "explore","Search", Icons.Filled.Search)
    object SavedScreen : Screen (route = "saved_screen","Saved", Icons.Filled.Favorite)
}
