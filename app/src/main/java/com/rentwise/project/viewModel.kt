package com.rentwise.project

import android.util.Log


class viewModel {
   /*fun changeState() {
       when (DataClass.currentState) {
           DataClass.AppState.START -> {
               DataClass.currentState = DataClass.AppState.LOGIN
           }

           DataClass.AppState.LOGIN -> {
               DataClass.currentState = DataClass.AppState.REGISTRO
           }

           DataClass.AppState.REGISTRO -> {
               DataClass.currentState = DataClass.AppState.LOGIN
           }
       }
   }*/

    fun changeState() {
        val currentStateValue = DataClass.currentState.value

        DataClass.currentState.value = when (currentStateValue) {
            DataClass.AppState.START -> DataClass.AppState.LOGIN
            DataClass.AppState.LOGIN -> DataClass.AppState.REGISTRO
            DataClass.AppState.REGISTRO -> DataClass.AppState.LOGIN
        }
        Log.d("Login", "Estado actual ha cambiado ha: ${DataClass.currentState.value}")
    }



}

