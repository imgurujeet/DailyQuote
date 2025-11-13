package com.imgurujeet.quoteapp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.imgurujeet.quoteapp.data.Categories
import com.imgurujeet.quoteapp.ui.theme.Regular14


@Composable
fun CategoryCard(
    modifier : Modifier,
    category: Categories,
    onClick: () -> Unit
){
    Card(
        modifier = modifier
            .width(110.dp)
            .height(120.dp)
            .clip(RoundedCornerShape(16.dp))
            .clickable { onClick(/* TODO */) }
           ,
    ) {
        Column(
            modifier = Modifier
            .fillMaxSize()
             .background(color = category.color.copy(alpha = 0.05f))
            .padding(horizontal = 10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Box(
                modifier = Modifier.size(60.dp)
                    .background(color = category.color.copy(alpha = 0.2f), CircleShape),
                contentAlignment = Alignment.Center

            ) {
                Icon(
                    imageVector = category.icon,
                    contentDescription = category.categoryName.name,
                    modifier = Modifier.size(45.dp).padding(10.dp),
                    tint = category.color
                )

            }
            Spacer(Modifier.height(10.dp))
            Text(
                text = category.categoryName.name,
                style = MaterialTheme.typography.Regular14,
                color = MaterialTheme.colorScheme.onBackground,
            )
        }

    }

}