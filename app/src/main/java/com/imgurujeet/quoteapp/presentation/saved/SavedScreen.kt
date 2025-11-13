package com.imgurujeet.quoteapp.presentation.saved

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.imgurujeet.quoteapp.data.Category
import com.imgurujeet.quoteapp.data.dummyQuotes
import com.imgurujeet.quoteapp.presentation.components.QuoteCardWide
import com.imgurujeet.quoteapp.presentation.components.cardColors
import com.imgurujeet.quoteapp.ui.theme.Bold24
import com.imgurujeet.quoteapp.ui.theme.Regular14

@Composable
fun SavedScreen(navHost: NavHostController, modifier: Modifier){
    Column(
        modifier = modifier.fillMaxSize(),

        ) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 10.dp)
        ) {
            Text(
                text = "Your Saved Quotes",
                style = MaterialTheme.typography.Bold24
            )


        }

    }
}