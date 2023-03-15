package com.example.movie2023.ui.movie

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ConcatAdapter
import com.example.movie2023.R
import com.example.movie2023.data.model.Movie
import com.example.movie2023.data.remote.MovieDataSource
import com.example.movie2023.databinding.FragmentMovieBinding
import com.example.movie2023.presentation.MovieViewModel
import com.example.movie2023.presentation.MovieViewModelFactory
import com.example.movie2023.repository.MovieRepositoryImpl
import com.example.movie2023.repository.RetrofitClient
import  com.example.movie2023.core.Result
import com.example.movie2023.ui.movie.adapters.MovieAdapter
import com.example.movie2023.ui.movie.adapters.concat.PopularConcatAdapter
import com.example.movie2023.ui.movie.adapters.concat.TopRatedConcatAdapter
import com.example.movie2023.ui.movie.adapters.concat.UpComingConcatAdapter

class MovieFragment : Fragment(R.layout.fragment_movie), MovieAdapter.OnMovieClickListener {

    private lateinit var binding: FragmentMovieBinding
    private lateinit var concatAdapter: ConcatAdapter

    private val viewModel by viewModels<MovieViewModel> {
        MovieViewModelFactory(MovieRepositoryImpl(MovieDataSource(RetrofitClient.webService)))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMovieBinding.bind(view)

        concatAdapter = ConcatAdapter()

        viewModel.fetchAllMovies().observe(viewLifecycleOwner, Observer { result ->
            when(result){
                is Result.Loading ->{
                    binding.progressBar.visibility = View.VISIBLE
                }
                is Result.Success ->{
                    binding.progressBar.visibility = View.GONE
                    concatAdapter.apply {
                        addAdapter(0, UpComingConcatAdapter(MovieAdapter(result.data.first.results, this@MovieFragment)))
                        addAdapter(1, TopRatedConcatAdapter(MovieAdapter(result.data.second.results, this@MovieFragment)))
                        addAdapter(2, PopularConcatAdapter(MovieAdapter(result.data.third.results, this@MovieFragment)))
                    }
                    binding.recyclerMovies.adapter = concatAdapter

                }
                is Result.Failure -> {
                    binding.progressBar.visibility = View.GONE
                    Log.e("LiveData", result.exception.toString())
                }
            }
        })
    }

    override fun onMovieClick(movie: Movie) {
        val action = MovieFragmentDirections.actionMovieFragmentToMovieDetailFragment(movie)
        findNavController().navigate(action)
    }
}