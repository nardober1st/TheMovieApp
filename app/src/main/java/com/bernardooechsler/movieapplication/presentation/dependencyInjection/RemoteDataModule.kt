package com.bernardooechsler.movieapplication.presentation.dependencyInjection

import com.bernardooechsler.movieapplication.data.api.TMBDService
import com.bernardooechsler.movieapplication.data.datasource.MovieRemoteDataSource
import com.bernardooechsler.movieapplication.data.datasourceImpl.MovieRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmbdService: TMBDService): MovieRemoteDataSource {
        return MovieRemoteDataSourceImpl(
            tmbdService, apiKey
        )
    }
}