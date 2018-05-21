package com.tistory.black_jin0427.mymaterialdesign.data

import com.tistory.black_jin0427.mymaterialdesign.model.Movie

fun getMovieItems(): MutableList<Movie> {

    val items = mutableListOf<Movie>()

    val movie1 = Movie("http://static.hubzum.zumst.com/hubzum/2018/02/06/09/962ec338ca3b4153b037168ec92756ac.jpg",
            "action", "Black Panther", "this movie open in 2018.01")

    val movie2 = Movie("http://cfile1.uf.tistory.com/image/0138F14A517F77713A43A6",
            "action", "Iron Man 3", "this movie open in 2013.04")

    val movie3 = Movie("https://i.ytimg.com/vi/5-mWvUR7_P0/maxresdefault.jpg",
            "action", "Ant Man", "this movie open in 2015.06")

    items.add(movie1)
    items.add(movie2)
    items.add(movie3)

    return items
}