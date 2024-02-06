package com.rentwise.project.database.sqlite

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rentwise.project.database.sqlite.houses.HouseDAO
import com.rentwise.project.database.sqlite.houses.Houses
import com.rentwise.project.database.sqlite.users.Users
import com.rentwise.project.database.sqlite.users.UsersDAO


@Database(entities = [Users::class , Houses::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDAO(): UsersDAO
    abstract fun houseDAO():HouseDAO

}
