package com.gc.desktopclock.app

import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.gc.desktopclock.presentation.main.MainScreenView
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
@Preview
fun App() {
    MaterialTheme {
        val navController = rememberNavController()

        NavHost(
            navController = navController,
            startDestination = Route.ClockGraph
        ) {
            navigation<Route.ClockGraph>(
                startDestination = Route.MainScreen

            ) {
                composable<Route.MainScreen>(
                    exitTransition = { slideOutHorizontally() },
                    popEnterTransition = {
                        slideInHorizontally()
                    }
                ) {
                    MainScreenView()
                }


            }

        }


    }
}