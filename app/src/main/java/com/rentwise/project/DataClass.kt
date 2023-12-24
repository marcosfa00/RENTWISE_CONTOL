package com.rentwise.project

object DataClass {
    data class User(
        val dni: String,
        val email: String,
        val phoneNumber: String,
        val username: String,
        val password: String,
        val dateOfBirth: String,
        val currentState: AppScreenState = AppScreenState.LOGIN
    )
    enum class AppScreenState {
        LOGIN,
        REGISTRO
    }
}