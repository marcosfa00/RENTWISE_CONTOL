package com.rentwise.project.ui.theme

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rentwise.project.ViewModel


@Composable
fun WelcomeHome(vModel: ViewModel) {
    // Contenedor principal
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Título
        Text(
            text = "Bienvenido a Nuestra Inmobiliaria",
            style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Lista de casas
        HouseItem("Casa 1", "Descripción de la Casa 1")
        HouseItem("Casa 2", "Descripción de la Casa 2")
        HouseItem("Casa 3", "Descripción de la Casa 3")
        // Puedes agregar más elementos según sea necesario
    }
}
@Composable
fun HouseItem(title: String, description: String) {
    // Elemento de la casa
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { /* Manejar clic en la casa */ }

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


