package com.example.movie2023.repository

import com.example.movie2023.core.InternetCheck
import com.example.movie2023.core.toMovieEntity
import com.example.movie2023.data.local.LocalMovieDataSource
import com.example.movie2023.data.model.MovieList
import com.example.movie2023.data.remote.RemoteMovieDataSource
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val remoteMovieDataSource: RemoteMovieDataSource,
    private val localMovieDataSource: LocalMovieDataSource,
    private val internetCheck: InternetCheck
) : MovieRepository {

    override suspend fun getUpcomingMovies(): MovieList {

        if(internetCheck.isConnected){
            remoteMovieDataSource.getUpComingMovies().results.forEach { Movie ->
                localMovieDataSource.saveMovie(Movie.toMovieEntity("upcoming"))
            }
        }
        return localMovieDataSource.getUpComingMovies()
    }

    override suspend fun getTopRatedMovies(): MovieList {

        if(internetCheck.isConnected) {
            remoteMovieDataSource.getTopRatedMovies().results.forEach { Movie ->
                localMovieDataSource.saveMovie(Movie.toMovieEntity("toprated"))
            }
        }

        return localMovieDataSource.getTopRatedMovies()
    }

    override suspend fun getPopularMovies(): MovieList {

        if(internetCheck.isConnected){
            remoteMovieDataSource.getPopularMovies().results.forEach { Movie ->
                localMovieDataSource.saveMovie(Movie.toMovieEntity("popular"))
            }
        }

        return localMovieDataSource.getPopularMovies()
    }

}