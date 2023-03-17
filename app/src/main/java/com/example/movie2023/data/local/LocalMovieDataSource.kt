package com.example.movie2023.data.local


import com.example.movie2023.core.toMovieList
import com.example.movie2023.data.model.MovieList
import javax.inject.Inject

class LocalMovieDataSource @Inject constructor(private val movieDao: MovieDao) {

    suspend fun getUpComingMovies(): MovieList {
        return movieDao.getAllMovies().filter {it.movieType == "upcoming" }.toMovieList()
    }

    suspend fun getTopRatedMovies(): MovieList {
        return movieDao.getAllMovies().filter {it.movieType == "toprated" }.toMovieList()
    }

    suspend fun getPopularMovies(): MovieList {
        return movieDao.getAllMovies().filter {it.movieType == "popular" }.toMovieList()
    }

    suspend fun saveMovie(movieEntity: MovieEntity){
        movieDao.saveMovie(movieEntity)
    }
}