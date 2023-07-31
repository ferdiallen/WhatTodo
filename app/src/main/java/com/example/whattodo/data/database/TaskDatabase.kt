package com.example.whattodo.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.whattodo.data.dao.TaskDao
import com.example.whattodo.data.model.TaskModel

@Database(entities = [TaskModel::class], version = 1)
abstract class TaskDatabase : RoomDatabase() {
    abstract fun dao(): TaskDao
}