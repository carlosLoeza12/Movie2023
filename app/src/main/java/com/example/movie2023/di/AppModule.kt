package com.example.movie2023.di

import android.content.Context
import androidx.room.Room
import com.example.movie2023.application.AppConstants
import com.example.movie2023.data.local.AppDatabase
import com.example.movie2023.data.local.MovieDao
import com.example.movie2023.repository.WebService
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

// Donde se va a instalar el modulo, donde viviran y persistir las instancias del modulo
// en este caso el scoope es el modulo de aplicacion
//singleton = application

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(AppConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .client(AppConstants.okHttp.build())
            .build()


    @Singleton
    @Provides
    fun provideMovieService(retrofit: Retrofit): WebService = retrofit.create(WebService::class.java)


    @Singleton
    @Provides
    fun provideRoomInstance(@ApplicationContext context: Context) : AppDatabase =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
        "movie_table"
    ).build()

    @Provides
    @Singleton
    fun provideMovieDao(appDatabase: AppDatabase): MovieDao = appDatabase.movieDao()

    @Singleton
    @Provides
    fun provideContext(@ApplicationContext context: Context): Context = context
}