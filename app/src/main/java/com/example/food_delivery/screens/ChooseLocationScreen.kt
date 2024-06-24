package com.example.food_delivery.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import androidx.navigation.NavHostController

@Preview
@Composable
fun ChooseLocationScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 10.dp)
    ) {
        Text(
            text = "Choose Your Location",
            fontSize = 32.sp,
        )
        Spacer(modifier = Modifier.padding(16.dp))
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {
            dropDownMenu()

        }

    }
}


@Composable
fun dropDownMenu() {

    var expanded by remember { mutableStateOf(false) }
    val suggestions = listOf("surat" , "rajkot" , "bhavnagar" , "bharuch")
    var selectedText by remember { mutableStateOf("") }

    var textfieldSize by remember { mutableStateOf(Size.Zero) }

    val icon = if (expanded)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown


    Column(Modifier.padding(20.dp)) {
        OutlinedTextField(
            value = selectedText,
            onValueChange = { selectedText = it },
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    //This value is used to assign to the DropDown the same width
                    textfieldSize = coordinates.size.toSize()
                },
            readOnly = true,
            label = { Text("Label") },
            trailingIcon = {
                Icon(icon, "contentDescription",
                    Modifier.clickable { expanded = !expanded })
            }
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .width(with(LocalDensity.current) { textfieldSize.width.toDp() })
        ) {

            suggestions.forEach {
                label->
                DropdownMenuItem(text = { Text(text = label )}, onClick = {
                    selectedText = label
                    expanded = false
                })
            }
        }
    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropDown() {
    val itemList = listOf("select city", "surat", "ahmedabad", "rajkot", "vadodara", "bhavnagar")
    var isExpand by remember {
        mutableStateOf(false)
    }
    var selectedCity by remember {
        mutableStateOf(itemList[0])
    }
    ExposedDropdownMenuBox(expanded = isExpand, onExpandedChange = {
        isExpand != isExpand
    }) {
        TextField(
            modifier = Modifier.menuAnchor(),
            value = selectedCity,
            onValueChange = {},
            readOnly = true,
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpand) }
        )

        ExposedDropdownMenu(expanded = isExpand,
            onDismissRequest = {
                isExpand = !isExpand
            }) {
            itemList.forEachIndexed { index, text ->
                DropdownMenuItem(text = { Text(text = text) }, onClick = {
                    selectedCity = itemList[index]
                    isExpand = false
                },
                    contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                )
            }
        }
    }
}

@Composable
fun dp() {
    val itemList = listOf("surat" , "ahemadabad")
    var isExpaded by remember {
        mutableStateOf(false)
    }
    var selectedCity by remember {
        mutableStateOf("")
    }

}