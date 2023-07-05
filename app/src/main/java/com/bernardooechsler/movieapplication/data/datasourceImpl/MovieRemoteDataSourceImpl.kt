package com.bernardooechsler.movieapplication.data.datasourceImpl

import com.bernardooechsler.movieapplication.data.api.TMBDService
import com.bernardooechsler.movieapplication.data.datasource.MovieRemoteDataSource
import com.bernardooechsler.movieapplication.data.model.MovieList
import retrofit2.Response

/*
    The DataSourceImpl class is a specific implementation of a data source interface in an Android Kotlin application.
    It represents the concrete implementation of the methods defined in the corresponding datasource interface.

    In the context of the data access layer or repository pattern, the DataSourceImpl class typically encapsulates the
    logic for interacting with a specific data source, such as a database or a web service.
 */
class MovieRemoteDataSourceImpl(
    private val tmbdService: TMBDService, private val apiKey: String
) : MovieRemoteDataSource {

    override suspend fun getMovies(): Response<MovieList> = // Here we are connecting the getMovies() fun from our MovieRemoteDataSource to the getPopularMovies() from our TMDB API service class
        tmbdService.getPopularMovies(apiKey)
}