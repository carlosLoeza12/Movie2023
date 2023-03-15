package com.example.movie2023.repository

import com.example.movie2023.data.model.MovieList

interface MovieRepository {
   suspend fun getUpcomingMovies(): MovieList
   suspend fun getTopRatedMovies(): MovieList
   suspend fun getPopularMovies(): MovieList
}