package com.example.food_delivery.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
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


@Composable
fun SignUpScreen(navController: NavHostController) {
    var name = remember {
        mutableStateOf("")
    }
    var email = remember {
        mutableStateOf("")
    }
    var password = remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = null,
            modifier = Modifier.size(120.dp)
        )
        Text(text = "Wave of Food", fontSize = 36.sp, fontWeight = FontWeight.SemiBold)
        Text(
            text = "Deliver Favorite Food",
            color = green,
            fontSize = 18.sp,
            modifier = Modifier.padding(top = 10.dp)
        )
        Text(
            text = "Sign Up Here",
            modifier = Modifier.padding(14.dp),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = green
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = null,
            )
            OutlinedTextField(
                value = name.value,
                onValueChange = {
                    name.value = it
                },
                placeholder = { Text(text = "Name") },
            )
        }
        Spacer(modifier = Modifier.padding(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically

        ) {
            Icon(
                imageVector = Icons.Default.Email,
                contentDescription = null,
            )
            OutlinedTextField(
                value = email.value,
                onValueChange = {
                    email.value = it
                },
                placeholder = { Text(text = "Email") }
            )
        }
        Spacer(modifier = Modifier.padding(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically

        ) {
            Icon(
                imageVector = Icons.Default.Lock,
                contentDescription = null,
            )
            OutlinedTextField(
                value = password.value,
                onValueChange = {
                    password.value = it
                },
                placeholder = { Text(text = "Password") }
            )
        }
        Text(text = "or")
        Spacer(modifier = Modifier.padding(4.dp))
        Text(
            text = "Sign up With", modifier = Modifier.padding(14.dp),
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Card(
                modifier = Modifier,
                shape = RoundedCornerShape(12.dp),
            ) {
                Row {
                    Image(
                        painter = painterResource(id = R.drawable.facebookicon),
                        contentDescription = null
                    )
                    Text(text = "Facebook")
                }
            }
            Spacer(modifier = Modifier.padding(12.dp))
            Card(
                modifier = Modifier,
                shape = RoundedCornerShape(12.dp)
            ) {
                Row {
                    Image(
                        painter = painterResource(id = R.drawable.googleicon),
                        contentDescription = null
                    )
                    Text(text = "Google")
                }
            }
        }
        Spacer(modifier = Modifier.padding(12.dp))


        GradientButton(
            modifier = Modifier,
            text = "Create Account",
            textColor = Color.White,
            gradient = Brush.horizontalGradient(
                colors = listOf(
                    color1,
                    color2
                )
            )
        ) {
            navController.navigate("location")
        }
        Spacer(modifier = Modifier.padding(12.dp))
        Text(text = "Already Have An Account", color = green , modifier = Modifier.clickable {
            navController.navigate(DestinationScreen.LoginScreen.route)
        })

    }
}

