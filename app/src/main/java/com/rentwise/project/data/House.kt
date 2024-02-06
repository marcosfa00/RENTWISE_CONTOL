package com.rentwise.project.data

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

object House {
    var name by mutableStateOf("")
        set
    var country by mutableStateOf("")
        set
    var city by mutableStateOf("")
        set
    var address by mutableStateOf("")
        set
    var rent_hotel by mutableStateOf(false)
        set
    var price by mutableStateOf(0f)
        set

}