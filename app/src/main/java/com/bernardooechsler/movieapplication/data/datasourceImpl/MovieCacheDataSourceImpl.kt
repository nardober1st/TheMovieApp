package com.bernardooechsler.movieapplication.data.datasourceImpl

import com.bernardooechsler.movieapplication.data.datasource.MovieCacheDataSource
import com.bernardooechsler.movieapplication.data.model.Movie

/*
    The DataSourceImpl class is a specific implementation of a data source interface in an Android Kotlin application.
    It represents the concrete implementation of the methods defined in the corresponding datasource interface.

    In the context of the data access layer or repository pattern, the DataSourceImpl class typically encapsulates the
    logic for interacting with a specific data source, such as a database or a web service.
 */
class MovieCacheDataSourceImpl : MovieCacheDataSource {

    private var movieList = ArrayList<Movie>()

    override suspend fun getMoviesFromCache(): List<Movie> {
        return movieList
    }

    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movies)
    }
}