package com.example.whattodo.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TaskModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val taskName: String,
    val description: String,
    val dueDate: String
)
