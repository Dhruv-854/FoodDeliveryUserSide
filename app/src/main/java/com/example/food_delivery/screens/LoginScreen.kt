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
import androidx.compose.material3.Card
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
fun LoginScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var email = remember {
            mutableStateOf("")
        }
        var password = remember {
            mutableStateOf("")
        }

        Image(
            painter = painterResource(id = R.drawable.logo), contentDescription = null,
            modifier = Modifier
                .padding(top = 80.dp)
                .size(110.dp)
        )
        Text(text = "Wave of Food", fontSize = 36.sp, fontWeight = FontWeight.SemiBold)
        Text(
            text = "Deliver Favorite Food",
            color = green,
            fontSize = 18.sp,
            modifier = Modifier.padding(top = 10.dp)
        )
        Text(
            text = "Login To Your Account",
            color = green,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 12.dp)
        )

        OutlinedTextField(
            value = email.value,
            onValueChange = { email.value = it },
            label = { Text(text = "Email") },
            modifier = Modifier.padding(top = 10.dp)
        )
        OutlinedTextField(
            value = password.value,
            onValueChange = { password.value = it },
            label = { Text(text = "Password") },
            modifier = Modifier.padding(top = 10.dp)
        )
        Text(text = "or", modifier = Modifier.padding(top = 16.dp), fontSize = 16.sp)
        Text(text = "Continue With", fontSize = 24.sp, modifier = Modifier.padding(bottom = 30.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Card(
                modifier = Modifier,
                shape = RoundedCornerShape(12.dp),
            ) {
                Row {
                    Image(painter = painterResource(id = R.drawable.facebookicon), contentDescription = null)
                    Text(text = "Facebook")
                }
            }
            Spacer(modifier = Modifier.padding(12.dp))
            Card(
                modifier = Modifier,
                shape = RoundedCornerShape(12.dp)
            ) {
                Row {
                    Image(painter = painterResource(id = R.drawable.googleicon), contentDescription = null)
                    Text(text = "Google")
                }
            }
        }



        GradientButton(
            modifier = Modifier,
            text = "Login",
            textColor = Color.White,
            gradient = Brush.horizontalGradient(
                colors = listOf(
                    color1,
                    color2
                )
            )
        ) {
            navController.navigate(DestinationScreen.SignUpScreen.route)
        }
        Text(text = "Don't Have Account?" , color = green , modifier = Modifier.padding(12.dp).clickable {
            navController.navigate(DestinationScreen.SignUpScreen.route)
        })
        Text(
            text = "     Design By\nDhruv Radadiya",
            modifier = Modifier.padding(top = 40.dp),
            color = green,
            fontSize = 16.sp
        )

    }
}

