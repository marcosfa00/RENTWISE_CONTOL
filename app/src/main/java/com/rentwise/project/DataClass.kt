package com.rentwise.project

import androidx.compose.runtime.mutableStateOf

object DataClass {

    val dni = mutableStateOf("")
    val email = mutableStateOf("")
    val phoneNumber = mutableStateOf("")
    val username = mutableStateOf("")
    val password = mutableStateOf("")
    val dateOfBirth = mutableStateOf("")
    //var currentState =AppState.START
    var currentState = mutableStateOf(AppState.START)
    /**
     * Enum Estados de la aplicación
     */
    enum class AppState {
        START,// Estado inicial de la aplicación
        LOGIN,// Estado de la aplicación cuando se está en la pantalla de login
        REGISTRO,// Estado de la aplicación cuando se está en la pantalla de registro
    }
}