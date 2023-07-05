package com.bernardooechsler.movieapplication.domain.repository

import com.bernardooechsler.movieapplication.data.model.Movie

/*
    *** Repository ***

    In Kotlin, a repository class is commonly used as an intermediary between the use case classes and the ViewModel
    in an architecture like Model-View-ViewModel (MVVM). The repository class acts as a single source of truth for
    data operations and provides an abstraction layer for data access.

    By using a repository class, you can decouple the ViewModel from the data source implementations and make it easier
    to test and maintain your code. It provides a clear separation of concerns, allowing the ViewModel to focus on the
    UI-related tasks while delegating data operations to the repository.
 */
interface MovieRepository {

    suspend fun getMovies(): List<Movie>?
    suspend fun updateMovies(): List<Movie>?
}