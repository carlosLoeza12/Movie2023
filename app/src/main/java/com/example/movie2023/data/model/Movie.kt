package com.example.movie2023.data.model
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieList(
    val results: List<Movie> = listOf()
): Parcelable

@Parcelize
data class Movie(
    val id: Int = -1,
    val poster_path: String = "",
    val adult: Boolean = false,
    val overview: String = "",
    val release_date: String = "",
    val original_title: String = "",
    val original_language: String = "",
    val title: String = "",
    val backdrop_path: String = "",
    val popularity: Double = 0.0,
    val vote_count: Int = -1,
    val video: Boolean = false,
    val vote_average: Double = 0.0,
    val movieType: String =""
): Parcelable
