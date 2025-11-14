package com.imgurujeet.quoteapp.presentation.components

import android.R
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Share
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
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.imgurujeet.quoteapp.data.Quote
import com.imgurujeet.quoteapp.ui.theme.Regular12
import com.imgurujeet.quoteapp.ui.theme.Regular14
import com.imgurujeet.quoteapp.ui.theme.SemiBold14
import com.imgurujeet.quoteapp.ui.theme.SemiBold16
import com.imgurujeet.quoteapp.ui.theme.SemiBold18
import kotlin.random.Random

@Composable
fun QuoteCard(
    modifier: Modifier,
    quote: Quote,
    color: Color,
    onShareClick: () -> Unit,
    onFavoriteClick: () -> Unit,
    onCardClick: () -> Unit
){
    Card(
        modifier = modifier
            .width(220.dp)
            .height(280.dp)
            .clip(RoundedCornerShape(16.dp))
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(

                            color,
                            color.copy(alpha = 0.6f),

                        )
                    )
                )
                .padding(horizontal = 20.dp)

        ){
            Row(
                modifier = Modifier.padding(vertical = 10.dp).fillMaxWidth().fillMaxHeight(0.2f),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween

            ) {
                Box(
                    modifier = Modifier.size(45.dp).background(color = Color.White.copy(alpha = 0.05f), CircleShape)

                ){}
                Row(
                    Modifier.padding(10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly,

                ){
                    Icon(
                        imageVector = Icons.Default.Share,
                        contentDescription = "Share",
                        tint = Color.White,
                        modifier = Modifier.clickable {
                            onShareClick( /* TODO */)
                        }
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Icon(
                        imageVector = if(quote.isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                        contentDescription = "favorite",
                        tint = Color.White,
                        modifier = Modifier.clickable {
                            onFavoriteClick( /* TODO */)
                        }
                    )
                }


            }
            Spacer(modifier = Modifier.height(20.dp))

            Column(
                modifier = Modifier.padding(all = 4.dp).fillMaxWidth().fillMaxHeight(0.8f)
                    .clickable {
                        onCardClick( /* TODO */)
                    },
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.Start

            ) {
                Text(
                    text = quote.quote,
                    style = MaterialTheme.typography.SemiBold16,
                    color = Color.White,
                    textAlign = TextAlign.Left,
                    maxLines = 5,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = "~ ${quote.author}",
                    style = MaterialTheme.typography.Regular12,
                    color = Color.White,
                    textAlign = TextAlign.Left,


                )
            }

        }


    }
}


val cardColors = listOf(
    Color(0xFF1E40AF),
    Color(0xFF090C10),
    Color(0xFF004D40),
    Color(0xFF880E4F),
    Color(0xFF4A148C),
    Color(0xFF002641),
    Color(0xFF1E40AF),
    Color(0xFF090C10),
    Color(0xFF004D40),
    Color(0xFF880E4F),
    Color(0xFF4A148C),
    Color(0xFF002641),
)

