package com.bernardooechsler.movieapplication.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/*
    "@Entity" means this class will have a mapping SQLite table in the database.
    "@PrimaryKey" can be used to specify the primary key for the entity.
    In Kotlin, the @SerializedName annotation is used in conjunction with
    frameworks like Gson or Moshi to specify the name of a field or property
    when serializing or deserializing JSON data.
 */
@Entity(tableName = "popular_movies")
data class Movie(
    @PrimaryKey
    @SerializedName("id")
    val id: Int,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("poster_path")
    val poster_path: String,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("title")
    val title: String
)
