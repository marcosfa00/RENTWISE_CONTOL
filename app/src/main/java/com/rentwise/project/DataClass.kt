package com.rentwise.project

import androidx.compose.runtime.mutableStateOf

object DataClass {

    val dni= String
    val email= String
    val phoneNumber= String
    val username= String
    val password= String
    val dateOfBirth= String
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