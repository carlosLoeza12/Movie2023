package com.example.movie2023.repository

import com.example.movie2023.data.model.MovieList
import com.example.movie2023.data.remote.MovieDataSource
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor (private val dataSource: MovieDataSource) : MovieRepository{

    override suspend fun getUpcomingMovies(): MovieList {
        return dataSource.getUpComingMovies()
    }

    override suspend fun getTopRatedMovies(): MovieList {
        return dataSource.getTopRatedMovies()
    }

    override suspend fun getPopularMovies(): MovieList {
        return dataSource.getPopularMovies()
    }

}