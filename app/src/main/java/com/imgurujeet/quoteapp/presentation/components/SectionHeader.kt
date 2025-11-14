package com.imgurujeet.quoteapp.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.imgurujeet.quoteapp.ui.theme.Regular14
import com.imgurujeet.quoteapp.ui.theme.SemiBold18

@Composable
fun SectionHeader(
    title: String,
    onClick: () -> Unit
){
    Row(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Absolute.SpaceBetween

    ) {
        Text(
            title,
            style = MaterialTheme.typography.SemiBold18,
        )
        Text(
            "See All",
            style = MaterialTheme.typography.Regular14,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.clickable {
                onClick()
            }
        )

    }
}
