package com.bernardooechsler.movieapplication.data.model

import com.google.gson.annotations.SerializedName

// This class will store the array of results that stores movies objects in it.
data class MovieList(
    @SerializedName("results")
    val movies: List<Movie>
)
