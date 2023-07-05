package com.bernardooechsler.movieapplication.presentation.dependencyInjection

import com.bernardooechsler.movieapplication.data.datasource.MovieLocalDataSource
import com.bernardooechsler.movieapplication.data.datasourceImpl.MovieLocalDataSourceImpl
import com.bernardooechsler.movieapplication.data.db.MovieDAO
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDAO: MovieDAO): MovieLocalDataSource {
        return MovieLocalDataSourceImpl(movieDAO)
    }
}