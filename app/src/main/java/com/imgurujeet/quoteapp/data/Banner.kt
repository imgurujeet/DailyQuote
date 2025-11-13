package com.imgurujeet.quoteapp.data

data class Banner(
    val id:Int,
    val imageUrl:String
)


val dummyBanners = listOf(
    Banner(1,"https://quotefancy.com/media/wallpaper/3840x2160/3875492-Larry-Wall-Quote-Laziness-is-a-programmer-s-main-virtue.jpg"),
    Banner(2,"https://wisdomquotes.b-cdn.net/wp-content/uploads/life-is-short-quotes-live-but-moment-marcus-aurelius-wisdom-quotes.webp"),
    Banner(3,"https://quotefancy.com/media/wallpaper/3840x2160/1422983-Brian-Kernighan-Quote-90-of-the-functionality-delivered-now-is.jpg"),
    Banner(4,"https://picsum.photos/200/300"),

    )