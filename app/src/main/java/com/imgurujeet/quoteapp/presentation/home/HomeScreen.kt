package com.imgurujeet.quoteapp.presentation.home

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.imgurujeet.quoteapp.presentation.components.BannerSlider
import com.imgurujeet.quoteapp.presentation.components.CategoryCard
import com.imgurujeet.quoteapp.presentation.components.QuoteCard
import com.imgurujeet.quoteapp.presentation.components.SectionHeader
import com.imgurujeet.quoteapp.presentation.components.cardColors
import com.imgurujeet.quoteapp.data.categories
import com.imgurujeet.quoteapp.data.dummyBanners
import com.imgurujeet.quoteapp.data.dummyQuotesList
import com.imgurujeet.quoteapp.data.favoritesList
import com.imgurujeet.quoteapp.data.toggleFavorite
import com.imgurujeet.quoteapp.presentation.navigation.Screen
import com.imgurujeet.quoteapp.ui.theme.Bold24
import com.imgurujeet.quoteapp.ui.theme.Regular14

//@Preview(showBackground = true)
@Composable
fun HomeScreen(navHost: NavHostController, modifier: Modifier) {

    val context = LocalContext.current
    LazyColumn(
        modifier = modifier.fillMaxSize()
    ) {

        item {
            Text(
                "Explore ",
                style = MaterialTheme.typography.Bold24,
                modifier = Modifier.padding(horizontal = 12.dp)

            )
            Text(
                "Awesome quotes from our community",
                style = MaterialTheme.typography.Regular14,
                color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.8f),
                modifier = Modifier.padding(horizontal = 12.dp)

            )
        }

        item {
            BannerSlider(
                modifier = Modifier
                    .padding(horizontal = 12.dp, 20.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .height(200.dp),
                listOfBanners = dummyBanners
            )

        }

        item {

            SectionHeader(
                title = "Latest Quotes",
                onClick = { TODO() }
            )


            LazyRow(
                modifier = Modifier.padding(vertical = 14.dp)

            ) {
                items(dummyQuotesList.size) { quote ->
                    val bgColor = cardColors[quote % cardColors.size]
                    QuoteCard(
                        modifier = Modifier.padding(horizontal = 12.dp),
                        quote = dummyQuotesList[quote],
                        color = bgColor,
                        onShareClick = { TODO() },
                        onFavoriteClick = {
                            toggleFavorite(dummyQuotesList[quote],dummyQuotesList, favoritesList)
                            if(dummyQuotesList[quote].isFavorite){
                                Toast.makeText(context, "Saved", Toast.LENGTH_SHORT).show()

                            }else{
                                Toast.makeText(context, "Removed from favorites", Toast.LENGTH_SHORT).show()
                            }
                        },
                        onCardClick = {},
                    )

                }

            }

        }

        item {
            Spacer(Modifier.height(8.dp))
            SectionHeader(
                title = "Categories",
                onClick = {
                    navHost.navigate(Screen.ExploreScreen.route){
                        popUpTo(Screen.HomeScreen.route){
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }

                }
            )

            LazyRow(
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 14.dp)
            ) {
                items(categories.size) { category ->
                    CategoryCard(
                        modifier = Modifier.padding(horizontal = 6.dp),
                        category = categories[category],
                        onClick = ({
                            //navHost.navigate(Screen.ExploreScreen.route)
                            Log.d("Navigating to Explore", "HomeScreen: ${categories[category]}")
                            navHost.navigate("${Screen.ExploreScreen.route}?category=${categories[category].categoryName}") {
                                popUpTo(Screen.HomeScreen.route) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                // restoreState = true

                            }
                        })
                    )
                }

            }
        }

        item {

            SectionHeader(
                title = "Trending Quotes",
                onClick = { TODO() }
            )


            LazyRow(
                modifier = Modifier.padding(vertical = 14.dp)

            ) {
                items(dummyQuotesList.size) { quote ->
                    val bgColor = cardColors[quote % cardColors.size]
                    QuoteCard(
                        modifier = Modifier.padding(horizontal = 12.dp),
                        quote = dummyQuotesList[quote],
                        color = bgColor,
                        onShareClick = { TODO() },
                        onFavoriteClick = {

                            toggleFavorite(dummyQuotesList[quote],dummyQuotesList, favoritesList)
                            if(dummyQuotesList[quote].isFavorite){
                                Toast.makeText(context, "Saved", Toast.LENGTH_SHORT).show()

                            }else{
                                Toast.makeText(context, "Removed from favorites", Toast.LENGTH_SHORT).show()
                            }
                        },
                        onCardClick = { TODO() },
                    )

                }

            }

        }

    }
}




