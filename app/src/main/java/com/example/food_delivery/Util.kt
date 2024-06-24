@file:Suppress("UNUSED_EXPRESSION")

package com.example.food_delivery

import android.net.wifi.p2p.WifiP2pManager.DnsSdTxtRecordListener
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.LinearGradient
import androidx.compose.ui.unit.dp

@Composable
fun GradientButton(
    modifier: Modifier,
    text : String,
    textColor : Color,
    gradient: Brush,
    onClick:()->Unit
) {
    Button(

        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent
        ),
        onClick ={onClick()}) {
        Box (
            modifier = Modifier
                .background(gradient)
                .padding(horizontal = 16.dp, vertical = 8.dp),
            contentAlignment = Alignment.Center
        ){
            Text(text = text, color = textColor)
        }
        modifier
    }
}