package com.rentwise.project.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rentwise.project.R
import com.rentwise.project.ViewModel

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color


@Composable
fun WelcomeHome(vModel: ViewModel) {
    // Contenedor principal
    Box(){
        Image(
            painter = painterResource(id = R.drawable.pixel),
            contentDescription = "Descripción de la imagen",
            modifier = Modifier
                .fillMaxSize()
                .aspectRatio(0.4f)

        )


        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // Título
            BtnAddHouse(model = vModel)
            Text(
                text = "RENTWISE CONTROL",
                style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(40.dp,40.dp,20.dp,10.dp)
            )

            LazyColumn(){
                item {
                    repeat(16) {
                        HouseItem("Piso 1", "Piso en García Barbón", vModel)
                    }
                }
            }

            // Lista de casas


            // Puedes agregar más elementos según sea necesario
            Back(vModel,1)
        }
    }

}
@Composable
fun HouseItem(title: String, description: String, vModel: ViewModel) {
    // Elemento de la casa
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {
                /* Manejar clic en la casa */
                vModel.changeState(4)

            }

    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            // Título de la casa
            Text(
                text = title,
                style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(bottom = 8.dp)
            )

            // Descripción de la casa
            Text(
                text = description,
                style = TextStyle(fontSize = 16.sp),
                modifier = Modifier.padding(bottom = 8.dp)
            )

            // Puedes agregar más detalles de la casa según sea necesario
        }
    }
}


@Composable
fun BtnAddHouse(model: ViewModel) {
    var expanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        IconButton(
            onClick = { expanded = true },
            modifier = Modifier
                .size(56.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.primary)
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Add House",
                tint = Color.White
            )
        }

    }
}





