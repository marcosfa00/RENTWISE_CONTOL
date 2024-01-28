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
import androidx.compose.ui.unit.dp

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import com.rentwise.project.data.Data
import com.rentwise.project.ViewModel
import com.rentwise.project.data.TAG


/**
 * Here we will define all the composable functions that will be used to style our app.
 */





@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignIn(vModel: ViewModel) {
    // Estados para el valor del usuario y la contraseña
    val dniState = remember { mutableStateOf("") }
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
                value = dniState.value,
                onValueChange = { newValue -> dniState.value = newValue },
                label = { Text(text ="Usuario",
                    color = Color.Gray
                )},
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
                label = {
                    Text(text="Contraseña",
                        color = Color.Gray)
                        },
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
                LoginButton(dni = dniState.value, password = passwordState.value, vModel)
                OpenSignUpButton(vModel)
            }
        }
    }
}




@Composable
fun LoginButton(dni: String, password: String, vModel: ViewModel) {
    Button(
        onClick = {
            // Acción al presionar el botón de login
            Log.d(TAG, "Username: $dni")
            Log.d(TAG, "Password: $password")

            //vm.logIn(username,password)
            vModel.login(dni,password)


        },
        modifier = Modifier.padding(16.dp)
    ) {
        Text("Log In")
    }
}

@Composable
fun OpenSignUpButton(vModel: ViewModel) {
    val currentState = Data.currentState.value
    Button(
        onClick = {
            if (currentState == Data.AppState.LOGIN) {
                vModel.changeState()
            }
        },
        modifier = Modifier.padding(16.dp)
    ) {
        Text("Sign Up")
    }
}



