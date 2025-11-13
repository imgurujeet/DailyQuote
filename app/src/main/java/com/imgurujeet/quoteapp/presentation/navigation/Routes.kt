package com.imgurujeet.quoteapp.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val title: String, val icon: ImageVector ? = null) {
    object HomeScreen : Screen("Home", Icons.Filled.Home)
    object ExploreScreen : Screen("Search", Icons.Filled.Search)
    object SavedScreen : Screen ("Saved", Icons.Filled.Favorite)
}
