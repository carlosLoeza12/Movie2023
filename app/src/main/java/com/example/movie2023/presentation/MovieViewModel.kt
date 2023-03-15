package com.example.movie2023.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.movie2023.core.Result
import com.example.movie2023.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(private val repository: MovieRepository) : ViewModel(){

    fun fetchAllMovies() = liveData(Dispatchers.IO){

        //loading
        emit(Result.Loading())

        try {
            //success
            emit(
                Result.Success(
                    Triple(
                        repository.getUpcomingMovies(),
                        repository.getTopRatedMovies(),
                        repository.getPopularMovies()
                    )
                )
            )
        } catch (e: Exception) {
            //failure
            emit(Result.Failure(e))
        }

    }

}

//class MovieViewModelFactory(private val repo: MovieRepository) : ViewModelProvider.Factory {
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        return modelClass.getConstructor(MovieRepository::class.java).newInstance(repo)
//    }
//}
