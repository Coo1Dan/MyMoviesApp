package com.example.moviesapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.moviesapp.MainViewModel
import com.example.moviesapp.screens.DetailsScreen
import com.example.moviesapp.screens.MainScreen
import com.example.moviesapp.utils.Constants

sealed class Screens(val route: String) {
    data object Main : Screens(route = Constants.Screens.MAIN_SCREEN)
    data object Details : Screens(route = Constants.Screens.DETAILS_SCREEN)
}

@Composable
fun SetupNavHost(navController: NavHostController, viewModel: MainViewModel) {
    NavHost(
        navController = navController,
        startDestination = Screens.Main.route
    ) {
        composable(route = Screens.Main.route) {
            MainScreen(navController = navController, viewModel = viewModel)
        }
        composable(route = Screens.Details.route + "/{Id}") { backStackEntry ->
            DetailsScreen(
                viewModel = viewModel,
                itemId = backStackEntry.arguments?.getString("Id") ?: "1"
            )
        }
    }
}