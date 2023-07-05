package com.bernardooechsler.movieapplication.presentation.dependencyInjection

import android.content.Context
import androidx.room.Room
import com.bernardooechsler.movieapplication.data.db.MovieDAO
import com.bernardooechsler.movieapplication.data.db.TMDBDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideMovieDatabase(context: Context): TMDBDatabase {
        return Room.databaseBuilder(
            context, TMDBDatabase::class.java, "tmdbclient"
        ).build()
    }

    @Singleton
    @Provides
    fun provideMovieDao(tmdbDatabase: TMDBDatabase): MovieDAO {
        return tmdbDatabase.movieDao()
    }
}