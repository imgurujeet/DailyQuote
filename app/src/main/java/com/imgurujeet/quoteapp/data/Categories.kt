package com.imgurujeet.quoteapp.data

import android.graphics.drawable.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoGraph
import androidx.compose.material.icons.filled.Business
import androidx.compose.material.icons.filled.EnergySavingsLeaf
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Handshake
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import com.imgurujeet.quoteapp.R



data class Categories (
    val categoryName: Category,
    val icon: ImageVector,
    val color: Color
)

val categories = listOf<Categories>(
    Categories(
        categoryName = Category.Love,
        icon = Icons.Filled.Favorite,
        color = Color(0xFFE91E63)
    ),
    Categories(
        categoryName = Category.Motivation,
        icon = Icons.Filled.Star,
        color = Color(0xFF1D64FC)
    ),
    Categories(
        categoryName = Category.Success,
        icon = Icons.Filled.AutoGraph,
        color = Color(0xFF00D05A)
    ),
    Categories(
        categoryName = Category.Wisdom,
        icon = Icons.Filled.Lightbulb,
        color = Color(0xFFEA8200)
    ),

    Categories(
        categoryName = Category.Friendship,
        icon = Icons.Filled.Handshake,
        color = Color(0xFF5C0BFA)
    ),
    Categories(
        categoryName = Category.Business,
        icon = Icons.Filled.Business,
        color = Color(0xFFFF3D00)
    ),
    Categories(
        categoryName = Category.Life,
        icon = Icons.Filled.EnergySavingsLeaf,
        color = Color(0xFF00E676)
    ),


)

enum class Category {
    Love,
    Motivation,
    Success,
    Wisdom,
    Friendship,
    Business,
    Life
}