package com.rentwise.project.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import com.rentwise.project.data.Data


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
            Text(
                text = "RENTWISE CONTROL",
                style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold),
                modifier = Modifier.padding( 40.dp)
            )

            // Lista de casas
            HouseItem("Piso 1", "Piso en García Barbón", vModel)
            HouseItem("Piso 2", "Piso en el Calvario", vModel)
            HouseItem("Casa 3", "Casa en Sardoma", vModel)
            // Puedes agregar más elementos según sea necesario
            BackToLogIn(vModel)
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




