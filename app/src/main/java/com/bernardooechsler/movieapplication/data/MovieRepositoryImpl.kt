package com.bernardooechsler.movieapplication.data

import com.bernardooechsler.movieapplication.data.datasource.MovieCacheDataSource
import com.bernardooechsler.movieapplication.data.datasource.MovieLocalDataSource
import com.bernardooechsler.movieapplication.data.datasource.MovieRemoteDataSource
import com.bernardooechsler.movieapplication.data.model.Movie
import com.bernardooechsler.movieapplication.domain.repository.MovieRepository
import java.lang.Exception

/*
    This class will implement the movieRepository interface, that is connect with the useCase classes,
    that are connected with the viewModel class

    This class is taking the DataSource interfaces in its constructor, these DataSources interfaces
    are connected with their implementation classes that are connected with the source of data (local, remote, cache)

    This way, we are connecting the presentation layer with the data layer.
 */
class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
) : MovieRepository {

    override suspend fun getMovies(): List<Movie>? {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newListOfMovies = getMoviesFromApi()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDB(newListOfMovies)
        movieCacheDataSource.saveMoviesToCache(newListOfMovies)
        return newListOfMovies
    }

    private suspend fun getMoviesFromApi(): List<Movie> {
        lateinit var movieList: List<Movie>

        try {
            val response = movieRemoteDataSource.getMovies()
            val body = response.body()
            if (body != null) {
                movieList = body.movies
            }
        } catch (exception: Exception) {

        }
        return movieList
    }

    private suspend fun getMoviesFromROOM(): List<Movie> {
        lateinit var movieList: List<Movie>

        try {
            movieList = movieLocalDataSource.getMoviesFromDB()
        } catch (exception: Exception) {

        }
        if (movieList.isNotEmpty()) {
            return movieList
        } else {
            movieList = getMoviesFromApi()
            movieLocalDataSource.saveMoviesToDB(movieList)
        }
        return movieList
    }

    private suspend fun getMoviesFromCache(): List<Movie>? {
        lateinit var movieList: List<Movie>

        try {
            movieList = movieCacheDataSource.getMoviesFromCache()
        } catch (exception: Exception) {

        }
        if (movieList.isNotEmpty()) {
            return movieList
        } else {
            movieList = getMoviesFromROOM()
            movieCacheDataSource.saveMoviesToCache(movieList)
        }
        return movieList
    }
}