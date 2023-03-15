package com.example.movie2023.ui.moviedetails

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import coil.load
import com.example.movie2023.R
import com.example.movie2023.application.AppConstants
import com.example.movie2023.databinding.FragmentMovieDetailBinding

class MovieDetailFragment : Fragment(R.layout.fragment_movie_detail) {

    private val args by navArgs<MovieDetailFragmentArgs>()
    private lateinit var binding: FragmentMovieDetailBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentMovieDetailBinding.bind(view)
        setMovieData()
    }

    private fun setMovieData(){
        binding.txtMovieName.text = args.movie?.title ?: "N/A"
        binding.txtOverView.text = args.movie?.overview ?: "N/A"
        binding.imgMovie.load(AppConstants.BASE_IMAGE+args.movie?.backdrop_path)
        binding.imgBackGround.load(AppConstants.BASE_IMAGE+args.movie?.poster_path)
        binding.txtLanguage.text = "Language ${args.movie?.original_language ?: "N/A"}"
        binding.txtRelease.text = "Released ${args.movie?.release_date ?: "N/A" }"
        binding.txtRating.text = "${args.movie?.vote_average} ${args.movie?.vote_count} Reviews"
    }
}