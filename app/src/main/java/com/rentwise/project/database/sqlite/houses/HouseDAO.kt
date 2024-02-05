package com.rentwise.project.database.sqlite.houses

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

/**
 * Interfaz que define las operaciones de acceso a datos (DAO) para la entidad House.
 */
@Dao
interface HouseDAO {

    @Query("SELECT * FROM houses")
    suspend fun getAllHouses(): List<Houses>
    @Query("SELECT * FROM houses WHERE id = :id")
    fun getHousesById(id: String): Houses?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHouse(house: Houses)

    @Update
    fun updateHouse(house: Houses)

    @Delete
    fun deleteHouse(house: Houses)
}