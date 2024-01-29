package com.rentwise.project

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rentwise.project.data.Data
import com.rentwise.project.data.Data.currentState
import com.rentwise.project.data.Data.usersList
import com.rentwise.project.data.TAG
import com.rentwise.project.data.User
import com.rentwise.project.database.Users
import com.rentwise.project.database.UsersDAO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class ViewModel(private val modelDAO : UsersDAO) : ViewModel(){

    /**
     * Cambia el estado de la aplicación según el número proporcionado.
     *
     * Esta función actualiza el valor del estado actual ([Data.currentState]) según el número proporcionado.
     * La transición de estados se realiza de la siguiente manera:
     *
     * - Si el número es 0: De [Data.AppState.START] a [Data.AppState.LOGIN]
     * - Si el número es 1: De [Data.AppState.LOGIN] a [Data.AppState.REGISTRO]
     * - Si el número es 2: De [Data.AppState.REGISTRO] a [Data.AppState.HOME]
     * - Si el número es 3: De [Data.AppState.HOME] a [Data.AppState.HOUSE]
     * - Si el número es 4: De [Data.AppState.HOUSE] a [Data.AppState.HOME]
     *
     * Después de cambiar el estado, se registra la nueva configuración en el registro de eventos.
     *
     * @param number Número que indica la transición de estado deseada.
     *        Debe estar en el rango 0-4 para realizar una transición válida.
     */
    fun changeState(number: Int) {
        val currentStateValue = Data.currentState.value

        Data.currentState.value = when (number) {
            0 -> Data.AppState.START
            1 -> Data.AppState.LOGIN
            2 -> Data.AppState.REGISTRO
            3 -> Data.AppState.HOME
            4 -> Data.AppState.HOUSE
            else -> currentStateValue // Mantener el estado actual si el número no está en el rango 0-4
        }

        Log.d(TAG, "Estado actual ha cambiado a: ${Data.currentState.value}")
    }


    /**
     * Registra un nuevo usuario en la base de datos utilizando un objeto [User].
     *
     * Esta función utiliza corutinas para realizar operaciones asíncronas, creando un objeto [Users] a partir
     * de la información proporcionada por el objeto [User] y realizando la inserción en la base de datos a través de [ModelDAO].
     *
     * @param user El objeto [User] que contiene la información del usuario a registrar.
     */
     fun register(user : User) {
        viewModelScope.launch {
            val usuario: Users = Users(user.dni,user.email,user.phoneNumber,user.username,user.password)
            Log.d(TAG, usuario.toString())
            modelDAO.insertUser(usuario)
        }
    }

    /**
     * Obtiene la lista de todos los usuarios almacenados en la base de datos.
     *
     * Esta función utiliza corutinas para realizar operaciones asíncronas, obteniendo la lista de usuarios
     * a través de [ModelDAO.getAllUsers] y registrando la información de cada usuario en el registro de eventos.
     */

    fun getUsers(){
      viewModelScope.launch {
            usersList = modelDAO.getAllUsers().toMutableList()
                Log.d(TAG, usersList.toString())

        }
    }


    /**
     *  big O(1)
     *  * Realiza el proceso de inicio de sesión utilizando el DNI (Documento Nacional de Identidad) y la contraseña proporcionados.
     *  *
     *  * Este método utiliza corutinas para realizar operaciones asíncronas, permitiendo el acceso a la base de datos en un hilo de entrada/salida.
     *  *
     *  * @param dni El número de DNI del usuario que intenta iniciar sesión.
     *  * @param pwd La contraseña proporcionada por el usuario para iniciar sesión.
     *  *
     */
    fun login(dni:String,pwd:String){
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
            val user = modelDAO.getUserById(dni)
            if (user != null) {
                if (  user.pwd == pwd ){
                    Log.d(TAG, "logeado $user")
                    currentState.value = Data.AppState.HOME

                }


            }
                }
        }
    }







    }
