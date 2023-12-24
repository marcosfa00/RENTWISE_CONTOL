package com.rentwise.project.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rentwise.project.DataClass

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CenteredMyForm() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        MyForm()
    }
}
@OptIn( ExperimentalMaterial3Api::class)
@Composable
fun MyForm() {
    val dni = DataClass.dni.value
    val email = DataClass.email.value
    val phoneNumber = DataClass.phoneNumber.value
    val username = DataClass.username.value
    val password = DataClass.password.value
    val dateOfBirth = DataClass.dateOfBirth.value

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        OutlinedTextField(
            value = dni,
            onValueChange = { DataClass.dni.value = it },
            label = { Text("DNI") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        OutlinedTextField(
            value = email,
            onValueChange = { DataClass.email.value = it },
            label = { Text("Correo") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )

        OutlinedTextField(
            value = phoneNumber,
            onValueChange = { DataClass.phoneNumber.value = it },
            label = { Text("Teléfono") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
        )

        OutlinedTextField(
            value = username,
            onValueChange = { DataClass.username.value = it },
            label = { Text("Usuario") }
        )

        OutlinedTextField(
            value = password,
            onValueChange = { DataClass.password.value = it },
            label = { Text("Contraseña") },
            visualTransformation = PasswordVisualTransformation()
        )

        OutlinedTextField(
            value = dateOfBirth,
            onValueChange = { /* Puedes manejar la lógica de selección de fecha aquí */ },
            label = { Text("Fecha de nacimiento") },
            readOnly = true // Para propósitos de visualización, podrías abrir un diálogo de selección de fecha al hacer clic
        )

        // Agregar un botón u otros elementos de UI para el envío del formulario o la selección de fecha
    }
}


@Composable
fun SignUpButton() {
    Button(
        onClick = {
            // Acción al presionar el botón de registro

        },
        modifier = Modifier.padding(top = 8.dp)
    ) {
        Text(text = "Registrarse")
    }
}

@Composable
fun BackToLogIn(){
    Button(
        onClick = {
            // Acción al presionar el botón de registro

        },
        modifier = Modifier.padding(top = 8.dp)
    ) {
        Text(text = "Volver al login")
    }
}


