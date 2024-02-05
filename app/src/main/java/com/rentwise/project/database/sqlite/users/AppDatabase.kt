package com.rentwise.project.database.sqlite.users

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [Users::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDAO(): UsersDAO

}
