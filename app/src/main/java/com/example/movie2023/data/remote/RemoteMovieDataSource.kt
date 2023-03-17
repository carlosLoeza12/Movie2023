package com.example.movie2023.data.remote

import com.example.movie2023.application.AppConstants
import com.example.movie2023.data.model.MovieList
import com.example.movie2023.repository.WebService
import javax.inject.Inject

class RemoteMovieDataSource @Inject constructor (private val webService: WebService) {

    suspend fun getUpComingMovies(): MovieList {
        return webService.getUpComingMovies(AppConstants.API_KEY)
    }

    suspend fun getTopRatedMovies(): MovieList {
        return webService.getTopRatedMovies(AppConstants.API_KEY)
    }

    suspend fun getPopularMovies(): MovieList {
        return webService.getPopularMovies(AppConstants.API_KEY)
    }

}