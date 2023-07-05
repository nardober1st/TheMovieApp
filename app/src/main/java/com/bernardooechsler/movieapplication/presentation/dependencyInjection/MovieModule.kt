package com.bernardooechsler.movieapplication.presentation.dependencyInjection

import com.bernardooechsler.movieapplication.domain.usecases.GetMoviesUseCase
import com.bernardooechsler.movieapplication.domain.usecases.UpdateMovieUseCase
import com.bernardooechsler.movieapplication.presentation.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase, updateMovieUseCase: UpdateMovieUseCase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(
            getMoviesUseCase, updateMovieUseCase
        )
    }
}