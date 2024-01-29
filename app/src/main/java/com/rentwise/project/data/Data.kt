package com.rentwise.project.data

import androidx.compose.runtime.mutableStateOf
import com.rentwise.project.database.Users

val TAG = "Login"
object Data {

    //List of users in the database
    var usersList : MutableList<Users> = mutableListOf()
    //var currentState =AppState.START
    var currentState = mutableStateOf(AppState.START)

    /**
     * Enumeración que representa los posibles estados de la aplicación.
     *
     * - [START]: Estado inicial de la aplicación.
     * - [LOGIN]: Estado de la aplicación cuando se está en la pantalla de login.
     * - [REGISTRO]: Estado de la aplicación cuando se está en la pantalla de registro.
     * - [HOME]: Estado de la aplicación cuando ha superado el inicio de sesión.
     * - [HOUSE]: Estado de la aplicacion cuando se accede a la casa / Piso
     */
    enum class AppState {
        START,    // 0 Estado inicial de la aplicación.
        LOGIN,    // 1 Estado de la aplicación cuando se está en la pantalla de login.
        REGISTRO, // 2 Estado de la aplicación cuando se está en la pantalla de registro.
        HOME,      // 3 Estado de la aplicación cuando ha superado el inicio de sesión.
        HOUSE     // 4 Estado de la aplicacion cuando se accede a una casa/Piso
    }
}

