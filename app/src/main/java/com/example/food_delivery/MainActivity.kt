package com.example.food_delivery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.food_delivery.screens.ChooseLocationScreen
import com.example.food_delivery.screens.LoginScreen
import com.example.food_delivery.screens.SignUpScreen
import com.example.food_delivery.screens.StartScreen
import com.example.food_delivery.ui.theme.FooddeliveryTheme


sealed class DestinationScreen(val route: String) {
    object StartScreen : DestinationScreen("start")
    object LoginScreen : DestinationScreen("login")
    object SignUpScreen : DestinationScreen("signup")
    object ChooseLocationScreen : DestinationScreen("location")
}


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FooddeliveryTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = DestinationScreen.StartScreen.route
                    ) {
                        composable(DestinationScreen.StartScreen.route){
                            StartScreen(navController)
                        }
                        composable(DestinationScreen.LoginScreen.route){
                            LoginScreen(navController)
                        }
                        composable(DestinationScreen.SignUpScreen.route){
                            SignUpScreen(navController)
                        }
                        composable(DestinationScreen.ChooseLocationScreen.route){
                            ChooseLocationScreen(navController)
                        }

                    }
                }
            }
        }
    }
}

