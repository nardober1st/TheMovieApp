package com.bernardooechsler.movieapplication.data.datasource

import com.bernardooechsler.movieapplication.data.model.Movie

/*
    In an Android Kotlin application, the datasource layer and datasource interfaces play a significant
    role in managing data retrieval and storage. They are part of the overall architecture pattern commonly
    known as the "Data Access Layer" or "Repository Pattern."

    The datasource layer is responsible for abstracting the details of data storage and retrieval, providing
    a consistent and unified interface to the rest of the application. It separates the business logic from the
    underlying data sources, such as databases, web services, or local storage.

    Datasource interfaces, on the other hand, define contracts or APIs that specify how the data will be accessed or manipulated.
    These interfaces serve as blueprints for the different data sources that implement them. By using interfaces, you can
    decouple your application from specific implementations, making it easier to switch between different data sources or mock data during testing.

    By utilizing this approach, your app's business logic can interact with the UserDataSource interface without
    knowing the specific implementation details. This separation allows for easier maintenance, testing, and
    swapping of data sources if needed.

    Overall, the datasource layer and datasource interfaces provide a structured and modular way to handle data
    access in Android Kotlin applications, promoting code re-usability, testability, and flexibility.
 */
interface MovieLocalDataSource {

    suspend fun getMoviesFromDB(): List<Movie>

    suspend fun saveMoviesToDB(movies: List<Movie>)

    suspend fun clearAll()
}