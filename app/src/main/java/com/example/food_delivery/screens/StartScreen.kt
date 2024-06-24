package com.example.food_delivery.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.food_delivery.DestinationScreen
import com.example.food_delivery.GradientButton
import com.example.food_delivery.R
import com.example.food_delivery.ui.theme.color1
import com.example.food_delivery.ui.theme.color2
import com.example.food_delivery.ui.theme.green

@Preview
@Composable
fun StartScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.backkgroundstart1),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .size(350.dp)
                .padding(top = 100.dp)
        )
        Text(
            text = "Enjoy Restaurant Quality Meals \n       " +
                    "             at home",
            modifier = Modifier.padding(top = 16.dp , bottom = 230.dp),
            fontSize = 20.sp,
            color = green,
        )
        GradientButton(
            modifier = Modifier.padding(top = 200.dp),
            text = "Next",
            textColor = Color.White,
            gradient = Brush.horizontalGradient(
                colors = listOf(
                    color1,
                    color2
                )
            )
        ) {
            navController.navigate(DestinationScreen.LoginScreen.route)
        }
        Text(
            text = "     Design By\nDhruv Radadiya",
            modifier = Modifier.padding(top = 40.dp),
            color = green,
            fontSize = 16.sp
        )
    }
}

