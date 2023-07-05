package com.bernardooechsler.movieapplication.data.api

import com.bernardooechsler.movieapplication.data.model.MovieList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/*
    The @GET annotation is used to specify that a particular function
    or method should handle HTTP GET requests to a specific endpoint or URL.

    By using the @GET annotation, you can define methods in your Retrofit API interface to handle
    different HTTP GET requests and specify the endpoints and any required parameters or headers.
    Retrofit will take care of the underlying networking tasks and provide you with the deserialized response.

    Here, we are also setting an specific @Query that will get the API Key

    *** Response Class ***

    In Kotlin and Retrofit, the Response class is a wrapper around an HTTP response returned by a Retrofit API call.
    It provides access to the response headers, status code, and the response body.

    By using the Response class, you can have access to both the response body and additional information
    related to the response, allowing you to handle different scenarios and errors effectively in your Retrofit-based API calls.
 */
interface TMBDService {

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query(
            "api_key"
        ) apiKey: String
    ): Response<MovieList>
}