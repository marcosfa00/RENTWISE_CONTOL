package com.rentwise.project

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rentwise.project.data.Data
import com.rentwise.project.data.Data.currentState
import com.rentwise.project.data.Data.usersList
import com.rentwise.project.data.House
import com.rentwise.project.data.TAG
import com.rentwise.project.data.User
import com.rentwise.project.database.sqlite.houses.HouseDAO
import com.rentwise.project.database.sqlite.houses.Houses
import com.rentwise.project.database.sqlite.users.Users
import com.rentwise.project.database.sqlite.users.UsersDAO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class ViewModel(private val userDAO : UsersDAO, private val houseDAO: HouseDAO) : ViewModel(){

    /**
     * Cambia el estado de la aplicación según el número proporcionado.
     *
     * Esta función actualiza el valor del estado actual ([Data.currentState]) según el número proporcionado.
     * La transición de estados se realiza de la siguiente manera:
     *
     * - Si el número es 0:  [Data.AppState.START]
     * - Si el número es 1:  [Data.AppState.LOGIN]
     * - Si el número es 2:  [Data.AppState.REGISTRO]
     * - Si el número es 3:  [Data.AppState.HOME]
     * - Si el número es 4:  [Data.AppState.HOUSE]
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
            userDAO.insertUser(usuario)
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
            usersList = userDAO.getAllUsers().toMutableList()
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
            val user = userDAO.getUserById(dni)
            if (user != null) {
                if (  user.pwd == pwd ){
                    Log.d(TAG, "logeado $user")
                    currentState.value = Data.AppState.HOME

                }


            }
                }
        }
    }


    /**
     * Registra una nueva casa en la base de datos.
     *
     * Este método asincrónico utiliza Coroutines para ejecutarse en un hilo de fondo,
     * permitiendo operaciones de larga duración sin bloquear el hilo principal de la interfaz de usuario.
     *
     * @param house La casa que se va a registrar en la base de datos.
     */
    fun registerHouse(house : House){
        viewModelScope.launch {
            val newHouse: Houses = Houses(0, house.name,house.country,house.city,house.address,house.rent_hotel,house.price)
            Log.d(TAG,newHouse.toString())
            houseDAO.insertHouse(newHouse)
        }
    }


    /*
     *A head are going to be implemented verification Methods, for the
     * Register of new users
     */


    /**
     * Funcion validar dni
     */
   private fun validateDNI(userDNI : String): Boolean{
        val dniRegex = Regex("^[0-9]{8}[TRWAGMYFPDXBNJZSQVHLCKE]\$", RegexOption.IGNORE_CASE)

        if (userDNI.matches(dniRegex)) {
            val numero = userDNI.substring(0, 8).toInt()
            val letra = userDNI.substring(8, 9).uppercase()

            // Array con las letras correspondientes a los números del DNI
            val letras = "TRWAGMYFPDXBNJZSQVHLCKE".toCharArray()

            // Calcula la letra correspondiente al número del DNI
            val letraCalculada = letras[numero % 23]

            // Compara la letra calculada con la letra proporcionada
            return letra == letraCalculada.toString()
        }

        return false
    }

    /**
     * Función para validar un correo electrónico.
     * @param userMail El correo electrónico a validar.
     * @return true si el correo es válido, false de lo contrario.
     */
    private fun validateEmail(userMail: String?): Boolean {
        val completeMail = userMail ?: return false // Verifica si el correo es nulo y retorna false si lo es

        if (!completeMail.contains("@")) {
            return false // Si no contiene "@", el correo no es válido
        }

        val mailParts = completeMail.split("@")
        if (mailParts.size != 2) {
            return false // Si no tiene exactamente dos partes después de dividir por "@", el correo no es válido
        }

        val localPart = mailParts[0]
        val domainPart = mailParts[1]

        if (localPart.isBlank() || domainPart.isBlank()) {
            return false // Si alguna parte está en blanco, el correo no es válido
        }

        // Puedes agregar más validaciones según tus requisitos, como validar el dominio, el formato, etc.
        // En este ejemplo, solo se verifica que el dominio tenga al menos un punto.
        if (!domainPart.contains(".")) {
            return false // Si el dominio no contiene al menos un punto, el correo no es válido
        }

        return true // Si llega hasta aquí, el correo es válido
    }










}
