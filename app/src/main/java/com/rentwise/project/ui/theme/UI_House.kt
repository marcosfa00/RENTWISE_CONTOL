package com.rentwise.project.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.rentwise.project.R
import com.rentwise.project.ViewModel


@Composable
fun InsideHouse(vModel: ViewModel) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Gray) // Color de fondo mientras carga la imagen
    ) {
        // Carga la imagen con Glide, Picasso u otra biblioteca de tu elección
        Image(
            painter = painterResource(id = R.drawable.background), // Reemplaza con la URL real
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // Contenido de la interfaz aquí
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Welcome To Your HOUSE",

                color = Color.White
            )

            // Puedes agregar más elementos aquí según tus necesidades
        }
        Back(vModel,3)
    }
}




