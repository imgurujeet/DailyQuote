package com.imgurujeet.quoteapp.data

import androidx.compose.runtime.mutableStateListOf
import com.imgurujeet.quoteapp.data.Quote

data class Quote(
    val quote: String,
    val author: String,
    val category: Category,
    var isFavorite: Boolean = false
)

val dummyQuotes = listOf(
    Quote(
        "The greatest glory in living lies not in never falling, but in rising every time we fall.",
        "Nelson Mandela",
        Category.Motivation
    ),
    Quote(
        "The way to get started is to quit talking and begin doing.",
        "Walt Disney",
        Category.Motivation
    ),
    Quote(
        "If life were predictable it would cease to be life, and be without flavor.",
        "Eleanor Roosevelt",
        Category.Life
    ),
    Quote(
        "If you set your goals ridiculously high and it's a failure, you will fail above everyone else's success.",
        "James Cameron",
        Category.Success
    ),
    Quote(
        "Life is what happens when you're busy making other plans.",
        "John Lennon",
        Category.Life
    ),
    Quote(
        "Spread love everywhere you go. Let no one ever come to you without leaving happier.",
        "Mother Teresa",
        Category.Love
    ),
    Quote(
        "When you reach the end of your rope, tie a knot in it and hang on.",
        "Franklin Roosevelt",
        Category.Motivation
    ),
    Quote(
        "Always remember that you are absolutely unique. Just like everyone else.",
        "Margaret Mead",
        Category.Wisdom
    ),
    Quote(
        "Discipline is the bridge between goals and accomplishment.",
        "Jim Rohn",
        Category.Motivation
    ),
    Quote("Your life is as good as your mindset.", "Unknown", Category.Life),
    Quote(
        "Do something today that your future self will thank you for.",
        "Sean Patrick Flanery",
        Category.Business
    ),
    Quote("It always seems impossible until it’s done.", "Nelson Mandela", Category.Success),
    Quote(
        "The harder you work for something, the greater you’ll feel when you achieve it.",
        "Unknown",
        Category.Wisdom
    ),
    Quote(
        "Success is not final, failure is not fatal: it is the courage to continue that counts.",
        "Winston Churchill",
        Category.Success
    )
)




val dummyQuotesList = mutableStateListOf<Quote>().apply {
    addAll(dummyQuotes)
}


val favoritesList = mutableStateListOf<Quote>().apply { }

fun toggleFavorite(
    quote: Quote,
    dummyQuotesList: MutableList<Quote>,
    favoritesList: MutableList<Quote>
) {
    val index = dummyQuotesList.indexOf(quote)
    if (index == -1) return

    // Create updated version
    val updated = quote.copy(isFavorite = !quote.isFavorite)

    // Update main list
    dummyQuotesList[index] = updated

    // Update favorites list
    if (updated.isFavorite) {
        if (!favoritesList.contains(updated)) {
            favoritesList.add(updated)
        }
    } else {
        favoritesList.removeAll { it.quote == updated.quote }
    }
}
