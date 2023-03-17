package com.example.movie2023.core

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import com.example.movie2023.data.local.MovieEntity
import com.example.movie2023.data.model.Movie
import com.example.movie2023.data.model.MovieList

//Room
fun List<MovieEntity>.toMovieList(): MovieList {

    val resultList: MutableList<Movie> = mutableListOf()

    this.forEach { movieEntity ->
        resultList.add(movieEntity.toMovie())
    }

    return MovieList(resultList)
}

fun MovieEntity.toMovie(): Movie {
    return Movie(
        this.id,
        this.poster_path,
        this.adult,
        this.overview,
        this.release_date,
        this.original_title,
        this.original_language,
        this.title,
        this.backdrop_path,
        this.popularity,
        this.vote_count,
        this.video,
        this.vote_average,
        this.movieType
    )
}

fun Movie.toMovieEntity(movieType: String): MovieEntity{
    return MovieEntity(
        this.id,
        this.poster_path,
        this.adult,
        this.overview,
        this.release_date,
        this.original_title,
        this.original_language,
        this.title,
        this.backdrop_path,
        this.popularity,
        this.vote_count,
        this.video,
        this.vote_average,
        movieType = movieType
    )
}

val Context.networkInfo: NetworkInfo?
    get() = (this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager).activeNetworkInfo
