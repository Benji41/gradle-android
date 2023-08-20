package com.reynoso.debug.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.firebase.analytics.FirebaseAnalytics
import com.reynoso.debug.screens.Screen
import com.reynoso.debug.screens.home.Home
import com.reynoso.debug.screens.login.Login

@Composable
fun Navigation(analytics: FirebaseAnalytics,navController: NavHostController = rememberNavController()) {
    Screen {
        NavHost(
            navController = navController,
            startDestination = Routes.Login.route
        ) {

            composable(Routes.Login.route) {
                Login(
                    analytics,
                    navigateToHome = {
                        navController.navigate(Routes.Home.route)
                    }
                )
            }

            composable(Routes.Home.route) {
                Home(analytics)
            }
        }
    }
}