package com.imgurujeet.quoteapp.data

data class Quote(
    val quote: String,
    val author: String,
    val category: Category,
)

val dummyQuotes = listOf(
    Quote("The greatest glory in living lies not in never falling, but in rising every time we fall.", "Nelson Mandela",Category.Motivation),
    Quote("The way to get started is to quit talking and begin doing.", "Walt Disney",Category.Motivation),
    Quote("If life were predictable it would cease to be life, and be without flavor.", "Eleanor Roosevelt",Category.Life),
    Quote("If you set your goals ridiculously high and it's a failure, you will fail above everyone else's success.", "James Cameron",Category.Success),
    Quote("Life is what happens when you're busy making other plans.", "John Lennon",Category.Life),
    Quote("Spread love everywhere you go. Let no one ever come to you without leaving happier.", "Mother Teresa",Category.Love),
    Quote("When you reach the end of your rope, tie a knot in it and hang on.", "Franklin Roosevelt",Category.Motivation),
    Quote("Always remember that you are absolutely unique. Just like everyone else.", "Margaret Mead",Category.Wisdom),

    )


val dummyTrendingQuotes = listOf(
    Quote("Dream big, start small, but most of all, start.", "Simon Sinek",Category.Motivation),
    Quote("Don’t let yesterday take up too much of today.", "Will Rogers",Category.Motivation),
    Quote("Success is not final, failure is not fatal: it is the courage to continue that counts.", "Winston Churchill",Category.Success),
    Quote("Push yourself, because no one else is going to do it for you.", "Unknown",Category.Motivation),
    Quote("Doubt kills more dreams than failure ever will.", "Suzy Kassem",Category.Motivation),
    Quote("Discipline is the bridge between goals and accomplishment.", "Jim Rohn",Category.Motivation),
    Quote("Your life is as good as your mindset.", "Unknown",Category.Life),
    Quote("Do something today that your future self will thank you for.", "Sean Patrick Flanery",Category.Business),
    Quote("It always seems impossible until it’s done.", "Nelson Mandela", Category.Success),
    Quote("The harder you work for something, the greater you’ll feel when you achieve it.", "Unknown",Category.Wisdom)
)

