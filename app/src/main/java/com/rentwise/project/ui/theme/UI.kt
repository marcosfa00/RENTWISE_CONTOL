package com.rentwise.project.ui.theme

import android.util.Log
import androidx.compose.foundation.layout.Box


import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding

import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
/**
 * Here we will define all the composable functions that will be used to style our app.
 */
@Composable
fun Greeting() {
    SignIn()
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RENTWISE_CONTROLTheme {
        Greeting()
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignIn() {
    // Estados para el valor del usuario y la contraseña
    val usernameState = remember { mutableStateOf("") }
    val passwordState = remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = usernameState.value,
                onValueChange = { newValue -> usernameState.value = newValue },
                label = { Text("Usuario") },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Gray, // Color del borde al estar enfocado
                    unfocusedBorderColor = Color.Gray, // Color del borde al no estar enfocado
                    textColor = Color.Black, // Color del texto
                    cursorColor = Color.Black // Color del cursor
                )
            )

            OutlinedTextField(
                value = passwordState.value,
                onValueChange = { newValue -> passwordState.value = newValue },
                label = { Text("Contraseña") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.padding(top = 8.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Gray, // Color del borde al estar enfocado
                    unfocusedBorderColor = Color.Gray, // Color del borde al no estar enfocado
                    textColor = Color.Black, // Color del texto
                    cursorColor = Color.Black // Color del cursor
                )
            )

            Row {
                LoginButton(username = usernameState.value, password = passwordState.value)
                SignUpButton()
            }
        }
    }
}




@Composable
fun LoginButton(username: String, password: String) {
    Button(
        onClick = {
            // Acción al presionar el botón de login
            Log.d("Login", "Username: $username")
            Log.d("Login", "Password: $password")
        },
        modifier = Modifier.padding(16.dp)
    ) {
        Text("Log In")
    }
}

@Composable
fun SignUpButton() {
    Button(
        onClick = {
            // Acción al presionar el botón de sign up
            /* TODO: Handle sign up */
        },
        modifier = Modifier.padding(16.dp)
    ) {
        Text("Sign Up")
    }
}



