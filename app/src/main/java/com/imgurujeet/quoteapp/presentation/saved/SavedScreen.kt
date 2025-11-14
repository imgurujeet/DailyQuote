package com.imgurujeet.quoteapp.presentation.saved

import android.widget.Toast
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.imgurujeet.quoteapp.data.Category
import com.imgurujeet.quoteapp.data.dummyQuotes
import com.imgurujeet.quoteapp.data.dummyQuotesList
import com.imgurujeet.quoteapp.data.favoritesList
import com.imgurujeet.quoteapp.data.toggleFavorite
import com.imgurujeet.quoteapp.presentation.components.QuoteCardWide
import com.imgurujeet.quoteapp.presentation.components.cardColors
import com.imgurujeet.quoteapp.ui.theme.Bold24
import com.imgurujeet.quoteapp.ui.theme.Regular14
import com.imgurujeet.quoteapp.ui.theme.SemiBold14

@Composable
fun SavedScreen(navHost: NavHostController, modifier: Modifier) {

    val context = LocalContext.current
    val favoriteQuotes = favoritesList
    val infiniteTransition = rememberInfiniteTransition()

    val offsetY by infiniteTransition.animateFloat(
        initialValue = -5f,
        targetValue = 5f,
        animationSpec = infiniteRepeatable(
            animation = tween(2000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )


    Column(
        modifier = modifier.fillMaxSize(),

        ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 10.dp)
        ) {
            Text(
                text = "Saved Quotes",
                style = MaterialTheme.typography.Bold24
            )


        }

        if (favoriteQuotes.isEmpty()) {

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            )
            {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "No Quotes Saved",
                    modifier = Modifier
                        .padding(bottom = 10.dp)
                        .size(60.dp)
                        .offset(y = offsetY.dp),
                    tint = Color.Red.copy(alpha = 0.2f),


                    )
                Text(
                    text = "No Quotes Saved", style = MaterialTheme.typography.SemiBold14,
                    color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.2f)
                )
            }
        } else {

            LazyColumn(
                modifier = Modifier.padding(vertical = 14.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)

            ) {

                items(favoriteQuotes.size) { quote ->
                    val bgColor = cardColors[quote % cardColors.size]

                    QuoteCardWide(
                        modifier = Modifier.padding(horizontal = 12.dp),
                        quote = favoriteQuotes[quote],
                        color = bgColor,
                        onShareClick = { TODO() },
                        onFavoriteClick = {
                            toggleFavorite(favoriteQuotes[quote], dummyQuotesList, favoritesList)
                            Toast.makeText(context, "Removed from favorites", Toast.LENGTH_SHORT).show()
                        },
                    )

                }

            }

        }

    }
}

