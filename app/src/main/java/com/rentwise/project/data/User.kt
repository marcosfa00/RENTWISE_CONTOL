package com.rentwise.project.data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

object  User {
    var dni by mutableStateOf("")
        public set

    var email by mutableStateOf("")
        public set

    var phoneNumber by mutableStateOf("")
        public set

    var username by mutableStateOf("")
        public set

    var password by mutableStateOf("")
        public set

    override fun toString(): String {
        return "User(dni=$dni, email=$email, phoneNumber=$phoneNumber, username=$username, password=$password)"
    }


}

