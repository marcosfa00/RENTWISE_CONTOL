package com.rentwise.project.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

/**
 * Interface with the dato, all the querys
 */
@Dao
interface UsersDAO {
    @Query("SELECT * FROM Users")
    suspend fun getAllUsers(): List<Users>

    @Query("SELECT * FROM Users WHERE dni = :dni")
    fun getUserById(dni: String): Users?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: Users)

    @Update
    fun updateUser(user: Users)

    @Delete
    fun deleteUser(user: Users)
}