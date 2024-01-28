package com.rentwise.project

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


    fun changeState() {
        val currentStateValue = Data.currentState.value

        Data.currentState.value = when (currentStateValue) {
            Data.AppState.START -> Data.AppState.LOGIN
            Data.AppState.LOGIN -> Data.AppState.REGISTRO
            Data.AppState.REGISTRO -> Data.AppState.LOGIN
            //corregir esto
            Data.AppState.HOME -> Data.AppState.LOGIN


        }
        Log.d(TAG, "Estado actual ha cambiado ha: ${Data.currentState.value}")


    }

     fun register(user : User) {
        viewModelScope.launch {
            val usuario: Users = Users(user.dni,user.email,user.phoneNumber,user.username,user.password)
            Log.d(TAG, usuario.toString())
            modelDAO.insertUser(usuario)
        }
    }


    fun getUsers(){
      viewModelScope.launch {
            usersList = modelDAO.getAllUsers().toMutableList()
            for (i in usersList.indices){
                Log.d(TAG, usersList.toString())
            }
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
