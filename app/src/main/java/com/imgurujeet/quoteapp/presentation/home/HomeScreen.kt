package com.imgurujeet.quoteapp.presentation.home

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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import com.imgurujeet.quoteapp.presentation.components.BannerSlider
import com.imgurujeet.quoteapp.presentation.components.CategoryCard
import com.imgurujeet.quoteapp.presentation.components.QuoteCard
import com.imgurujeet.quoteapp.presentation.components.SectionHeader
import com.imgurujeet.quoteapp.presentation.components.cardColors
import com.imgurujeet.quoteapp.data.categories
import com.imgurujeet.quoteapp.data.dummyBanners
import com.imgurujeet.quoteapp.data.dummyQuotes
import com.imgurujeet.quoteapp.data.dummyTrendingQuotes
import com.imgurujeet.quoteapp.ui.theme.Bold24
import com.imgurujeet.quoteapp.ui.theme.Regular14

//@Preview(showBackground = true)
@Composable
fun HomeScreen(navHost: NavHostController, modifier: Modifier) {
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
                items(dummyQuotes.size) { quote ->
                    val bgColor = cardColors[quote % cardColors.size]
                    QuoteCard(
                        modifier = Modifier.padding(horizontal = 12.dp),
                        quote = dummyQuotes[quote],
                        color = bgColor,
                        onShareClick = {TODO()},
                        onFavoriteClick = {TODO()},
                        onCardClick = {TODO()},
                    )

                }

            }

        }

        item {
            Spacer(Modifier.height(8.dp))
            SectionHeader(
                title = "Categories",
                onClick = { TODO() }
            )

            LazyRow(
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 14.dp)
            ) {
                items(categories.size) { category ->
                    CategoryCard(
                        modifier = Modifier.padding(horizontal = 6.dp),
                        category = categories[category],
                        onClick = ({ TODO() })
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
                items(dummyTrendingQuotes.size) { quote ->
                    val bgColor = cardColors[quote % cardColors.size]
                    QuoteCard(
                        modifier = Modifier.padding(horizontal = 12.dp),
                        quote = dummyTrendingQuotes[quote],
                        color = bgColor,
                        onShareClick = {TODO()},
                        onFavoriteClick = {TODO()},
                        onCardClick = {TODO()},
                    )

                }

            }

        }

    }
}




