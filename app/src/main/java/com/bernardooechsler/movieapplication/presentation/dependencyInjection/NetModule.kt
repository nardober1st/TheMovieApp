package com.bernardooechsler.movieapplication.presentation.dependencyInjection

import com.bernardooechsler.movieapplication.data.api.TMBDService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/*
    A module in Dagger is responsible for providing dependencies to the dependency
    injection graph. It contains methods annotated with @Provides, which specify how
    to create and provide instances of particular types. These methods can be used to
    define bindings for various dependencies, including concrete classes, interfaces, or other objects.

    When you annotate a class with @Module, Dagger recognizes it as a module class and analyzes
    its methods to generate the necessary code for dependency injection.

    The @Singleton annotation in Dagger is used to mark a dependency as a singleton. When a class is
    annotated with @Singleton, Dagger ensures that only one instance of that class is created and shared throughout the application.
 */
@Module
class NetModule(private val baseUrl: String) {

    @Singleton
    @Provides
    fun providesRetrofitInstance(): Retrofit {
        return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl).build()
    }

    @Singleton
    @Provides
    fun providesTMDBServices(retrofit: Retrofit): TMBDService {
        return retrofit.create(TMBDService::class.java)
    }
}