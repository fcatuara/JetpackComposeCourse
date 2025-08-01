package com.example.bizcardcomposecourse.movieapp.navigation

enum class MovieScreens {
    HomeScreen,
    MovieDetailScreen;

    companion object {
        fun fromRoute(route: String?): MovieScreens =
            when (route?.substringBefore("/")) {
                HomeScreen.name -> HomeScreen
                MovieDetailScreen.name -> MovieDetailScreen
                null -> HomeScreen
                else -> throw IllegalArgumentException("Route $route is not recognized")
            }
    }
}