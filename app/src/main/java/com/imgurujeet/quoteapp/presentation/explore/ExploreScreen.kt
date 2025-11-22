package com.imgurujeet.quoteapp.presentation.explore

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.FilterChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.imgurujeet.quoteapp.data.Category
import com.imgurujeet.quoteapp.data.dummyQuotes
import com.imgurujeet.quoteapp.presentation.components.QuoteCardWide
import com.imgurujeet.quoteapp.presentation.components.cardColors
import com.imgurujeet.quoteapp.ui.theme.Bold24
import com.imgurujeet.quoteapp.ui.theme.Regular14
import androidx.compose.runtime.setValue
import com.imgurujeet.quoteapp.data.dummyQuotesList
import com.imgurujeet.quoteapp.data.favoritesList
import com.imgurujeet.quoteapp.data.toggleFavorite

@Composable
fun ExploreScreen(  navHost: NavHostController, modifier: Modifier, selectedCategoryNav: Category? = null){

    var selectedCategory by remember { mutableStateOf(selectedCategoryNav) }


    val filterQuotes = if (selectedCategory != null) {
        dummyQuotesList.filter { it.category == selectedCategory }
    } else {
        dummyQuotesList
    }



    Column(
        modifier = modifier.fillMaxSize(),

    ) {
       Column(
           modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp)
       ) {
           Text(
               text = "Categories",
               style = MaterialTheme.typography.Bold24
           )
           LazyRow(
               horizontalArrangement = Arrangement.spacedBy(8.dp)
           ){
               val categories = Category.entries
               items(categories.size){ category ->
                   FilterChip(
                       selected = (selectedCategory == categories[category]),
                       onClick = {
                           if (selectedCategory != categories[category]) {
                               selectedCategory = categories[category]
                           } else {
                               selectedCategory = null
                           }

                       },
                       label = {
                           Text(
                               text = categories[category].name,
                               maxLines = 1,
                               style = MaterialTheme.typography.Regular14

                           )

                       }
                   )


               }


           }


           LazyColumn(
               modifier = Modifier.padding(vertical = 14.dp),
               verticalArrangement = Arrangement.spacedBy(12.dp)

           ) {

               items(filterQuotes.size) { quote ->
                   val bgColor = cardColors[quote % cardColors.size]
                   QuoteCardWide(
                       modifier = Modifier.padding(horizontal = 12.dp),
                       quote = filterQuotes[quote],
                       color = bgColor,
                       onShareClick = {TODO()},
                       onFavoriteClick = { toggleFavorite(filterQuotes[quote],dummyQuotesList, favoritesList)},
                   )

               }

           }

       }

    }
}