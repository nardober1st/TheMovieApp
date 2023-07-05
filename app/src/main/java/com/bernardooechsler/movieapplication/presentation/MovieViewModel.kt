package com.bernardooechsler.movieapplication.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.bernardooechsler.movieapplication.domain.usecases.GetMoviesUseCase
import com.bernardooechsler.movieapplication.domain.usecases.UpdateMovieUseCase

class MovieViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMovieUseCase: UpdateMovieUseCase
) : ViewModel() {

    fun getMovies() = liveData {
        val movieList = getMoviesUseCase.execute()
        emit(movieList)
    }

    fun updateMovies() = liveData {
        val movieList = updateMovieUseCase.execute()
        emit(movieList)
    }
}