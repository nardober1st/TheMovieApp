package com.bernardooechsler.movieapplication

import android.app.Application
import com.bernardooechsler.movieapplication.presentation.dependencyInjection.AppComponent
import com.bernardooechsler.movieapplication.presentation.dependencyInjection.AppModule
import com.bernardooechsler.movieapplication.presentation.dependencyInjection.DaggerAppComponent
import com.bernardooechsler.movieapplication.presentation.dependencyInjection.Injector
import com.bernardooechsler.movieapplication.presentation.dependencyInjection.MovieSubComponent
import com.bernardooechsler.movieapplication.presentation.dependencyInjection.NetModule
import com.bernardooechsler.movieapplication.presentation.dependencyInjection.RemoteDataModule

class App : Application(), Injector {
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder().appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY)).build()
    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }
}