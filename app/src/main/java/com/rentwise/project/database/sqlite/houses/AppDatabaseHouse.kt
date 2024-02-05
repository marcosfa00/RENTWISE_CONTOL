package com.rentwise.project.database.sqlite.houses

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities =[Houses::class], version = 1, exportSchema = false)
internal abstract class AppDatabaseHouse : RoomDatabase() {
    abstract fun houseDAO():HouseDAO
}