package com.bernardooechsler.movieapplication.presentation.dependencyInjection

import com.bernardooechsler.movieapplication.data.MovieRepositoryImpl
import com.bernardooechsler.movieapplication.data.datasource.MovieCacheDataSource
import com.bernardooechsler.movieapplication.data.datasource.MovieLocalDataSource
import com.bernardooechsler.movieapplication.data.datasource.MovieRemoteDataSource
import com.bernardooechsler.movieapplication.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ): MovieRepository {
        return MovieRepositoryImpl(
            movieRemoteDataSource, movieLocalDataSource, movieCacheDataSource
        )
    }
}