package com.reynoso.debug.navigation

sealed interface Routes {
    val route: String
    object Login : Routes {
        override val route: String
            get() = "Login"
    }

    object Home : Routes {
        override val route: String
            get() = "Home"
    }

}