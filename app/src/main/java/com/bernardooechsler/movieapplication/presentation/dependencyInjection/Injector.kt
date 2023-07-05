package com.bernardooechsler.movieapplication.presentation.dependencyInjection

interface Injector {

    fun createMovieSubComponent(): MovieSubComponent
}