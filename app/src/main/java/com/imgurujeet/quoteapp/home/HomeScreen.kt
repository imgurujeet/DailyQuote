package com.imgurujeet.quoteapp.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(){
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {

        item {
            Text(
                "Explore ",
                fontSize = 20.sp,
                modifier = Modifier.padding(16.dp),
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }
    }
}