package com.rentwise.project.ui.theme

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.rentwise.project.R
import com.rentwise.project.data.Data
import com.rentwise.project.data.User
import com.rentwise.project.ViewModel


@Composable
fun CenteredMyForm(vModel: ViewModel) {
    Box{
        Image(
            painter = painterResource(id = R.drawable.background), // Reemplaza con la URL real
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {

            MyForm(vModel)

        }

    }

}



@OptIn( ExperimentalMaterial3Api::class)
@Composable
fun MyForm(vModel : ViewModel) {



    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        LazyColumn() {

            item {

                OutlinedTextField(
                    value = User.dni,
                    onValueChange = { User.dni = it },
                    label = { Text("DNI") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )


                OutlinedTextField(
                    value = User.email,
                    onValueChange = { User.email = it },
                    label = { Text("Correo") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
                )


                OutlinedTextField(
                    value = User.phoneNumber,
                    onValueChange = { User.phoneNumber = it },
                    label = { Text("Teléfono") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
                )


                OutlinedTextField(
                    value = User.username,
                    onValueChange = { User.username = it },
                    label = { Text("Usuario") }
                )


            OutlinedTextField(
                value = User.password,
                onValueChange = { User.password = it },
                label = { Text("Contraseña") },
                visualTransformation = PasswordVisualTransformation()
            )
        }
        }

        Row {
            SignUpButton(vModel)
            Back(vModel,1)
        }
        // Agregar un botón u otros elementos de UI para el envío del formulario o la selección de fecha
    }
}


@Composable
fun SignUpButton(vModel : ViewModel) {
    Button(
        onClick = {
            // Acción al presionar el botón de registro
                vModel.register(User)

        },
        modifier = Modifier.padding(16.dp)
    ) {
        Text(text = "Registrarse")
    }
}

@Composable
fun Back(vModel:  ViewModel, state: Int){
    Button(
        onClick = {
            vModel.changeState(state)

        },
        modifier = Modifier.padding(16.dp)
    ) {
        Text(text = "Volver")
    }
}



