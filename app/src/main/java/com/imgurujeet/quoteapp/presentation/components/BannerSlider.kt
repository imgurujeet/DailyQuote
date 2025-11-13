package com.imgurujeet.quoteapp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.imgurujeet.quoteapp.data.Banner
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage


@Composable
fun BannerSlider(modifier: Modifier, listOfBanners:List<Banner>){

    val pageCount = listOfBanners.size

    val pagerState = rememberPagerState(
        pageCount = {pageCount}
    )

    Box(modifier = modifier) {


        HorizontalPager(state = pagerState) { page ->
            val banner = listOfBanners[page]

            AsyncImage(
                model = banner.imageUrl,
                contentDescription = "Banner $page",
                Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds
            )
        }
        Row(
            modifier = Modifier.align(Alignment.BottomCenter),
        ) {
            repeat(pagerState.pageCount) { index ->
                val color =
                    if (pagerState.currentPage == index) MaterialTheme.colorScheme.onSurface else MaterialTheme.colorScheme.surfaceVariant

                Box(
                    modifier = Modifier.padding(4.dp)
                        .size(12.dp).background(color = color, CircleShape)
                )
            }

        }

    }
}


