package com.example.movie2023.application

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

object AppConstants {

    //API
    const val BASE_URL = "https://api.themoviedb.org/3/movie/"
    const val API_KEY = "0215c862e4087e76d785b2285fc04422"
    const val BASE_IMAGE = "https://image.tmdb.org/t/p/w500/"

    // Create Logger
    private val logger = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    val okHttp = OkHttpClient.Builder().addInterceptor(logger)
}