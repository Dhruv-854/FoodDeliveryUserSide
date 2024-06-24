package com.example.food_delivery.screens

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.food_delivery.MainActivity
import com.example.food_delivery.R
import com.example.food_delivery.ui.theme.FooddeliveryTheme
import com.example.food_delivery.ui.theme.green
import kotlinx.coroutines.delay

@SuppressLint("CustomSplashScreen")
class SplashActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FooddeliveryTheme{
                SplashScreen()
            }
        }
    }
    @SuppressLint("RememberReturnType")
    @Composable
    fun SplashScreen() {
        val alpha = remember {
            androidx.compose.animation.core.Animatable(0f)
        }
        LaunchedEffect ( key1 = true ){
            alpha.animateTo(1f , animationSpec = tween(1500))
            delay(2000)
            startActivity(Intent(this@SplashActivity,MainActivity::class.java))

        }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 100.dp)
                    .alpha(alpha.value),
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Image(painter = painterResource(id = R.drawable.logo), contentDescription = "Logo")
                Text(
                    text = "Waves Of Food",
                    modifier = Modifier.padding(top = 30.dp),
                    fontSize = 40.sp
                )
                Text(
                    text = "Deliver Favorite Food",
                    modifier = Modifier.padding(top = 30.dp),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = "     Design By\nDhruv Radadiya",
                    modifier = Modifier.padding(top = 300.dp),
                    color = green,
                    fontSize = 16.sp
                )
            }
    }
}