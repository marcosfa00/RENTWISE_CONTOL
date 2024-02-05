package com.rentwise.project.database.sqlite.users

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

/**
 * Tabla de la Base de datos
 * name = Users (al no idicar un nombre por defecto coge el nombre de la clase
 *
 */
@Entity
data class Users(
    @PrimaryKey val dni : String,
    @ColumnInfo(name ="mail") val mail: String,
    @ColumnInfo(name = "telf") val telf : String,
    @ColumnInfo(name= "username") val  username: String,
    @ColumnInfo(name= "password") val pwd : String,
    // esta por determinar aun:
    // @ColumnInfo(name= "bornDate") val bornDate: Long

)