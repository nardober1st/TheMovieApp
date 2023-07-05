package com.bernardooechsler.movieapplication.domain.usecases

import com.bernardooechsler.movieapplication.data.model.Movie
import com.bernardooechsler.movieapplication.domain.repository.MovieRepository

/*
 UseCases serve as a bridge that will connect the repository with the viewModel
 This will make the app less dependent on the ViewModel
 It will also reduce of code duplication and complexity
 */
class UpdateMovieUseCase(private val movieRepository: MovieRepository) {

    suspend fun execute(): List<Movie>? = movieRepository.updateMovies()
}