package com.rentwise.project.data

import androidx.compose.runtime.mutableStateOf
import com.rentwise.project.database.Users

val TAG = "Login"
object Data {
    var usersList : MutableList<Users> = mutableListOf()

    //var currentState =AppState.START
    var currentState = mutableStateOf(AppState.START)
    /**
     * Enum Estados de la aplicación
     */
    enum class AppState {
        START,// Estado inicial de la aplicación
        LOGIN,// Estado de la aplicación cuando se está en la pantalla de login
        REGISTRO,// Estado de la aplicación cuando se está en la pantalla de registro
        HOME // Estado de la aplicacion cuando ha superado el Log In
    }
}

