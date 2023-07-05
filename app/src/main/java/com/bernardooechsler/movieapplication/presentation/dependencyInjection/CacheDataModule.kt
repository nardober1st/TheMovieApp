package com.bernardooechsler.movieapplication.presentation.dependencyInjection

import com.bernardooechsler.movieapplication.data.datasource.MovieCacheDataSource
import com.bernardooechsler.movieapplication.data.datasourceImpl.MovieCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MovieCacheDataSource {
        return MovieCacheDataSourceImpl()
    }
}