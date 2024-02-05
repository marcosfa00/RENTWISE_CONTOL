package com.rentwise.project.database.sqlite.houses


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


/**
 * Clase que representa una casa en la base de datos.
 *
 * @property id Identificador único de la casa. Se genera automáticamente.
 * @property name Nombre de la casa.
 * @property country País en el que se encuentra la casa.
 * @property city Ciudad en la que se encuentra la casa.
 * @property address Dirección de la casa.
 * @property rentHotel Indica si la casa se ofrece en alquiler (true) o es un hotel (false).
 * @property price Precio asociado a la casa.
 */
@Entity
data class Houses (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo (name = "name") val name:String,
    @ColumnInfo(name="country") val country:String,
    @ColumnInfo(name= "city") val city:String,
    @ColumnInfo(name= "address") val address:String,
    @ColumnInfo(name="renthotel") val rent_Hotel:Boolean,//True == RENT  False== HOTEL
    @ColumnInfo(name="price") val price:Float

)