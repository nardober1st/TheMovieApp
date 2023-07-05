package com.bernardooechsler.movieapplication.data.datasourceImpl

import com.bernardooechsler.movieapplication.data.datasource.MovieLocalDataSource
import com.bernardooechsler.movieapplication.data.db.MovieDAO
import com.bernardooechsler.movieapplication.data.model.Movie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/*
    The DataSourceImpl class is a specific implementation of a data source interface in an Android Kotlin application.
    It represents the concrete implementation of the methods defined in the corresponding datasource interface.

    In the context of the data access layer or repository pattern, the DataSourceImpl class typically encapsulates the
    logic for interacting with a specific data source, such as a database or a web service.
 */
class MovieLocalDataSourceImpl(
    private val movieDAO: MovieDAO
) : MovieLocalDataSource {

    override suspend fun getMoviesFromDB(): List<Movie> {
        return movieDAO.getMovies()
    }

    override suspend fun saveMoviesToDB(movies: List<Movie>) {
        CoroutineScope(Dispatchers.IO).launch {
            movieDAO.saveMovies(movies)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            movieDAO.deleteAllMovies()
        }
    }
}