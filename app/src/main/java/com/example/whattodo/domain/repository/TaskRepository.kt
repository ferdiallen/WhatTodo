package com.example.whattodo.domain.repository

import com.example.whattodo.data.dao.TaskDao
import com.example.whattodo.data.model.TaskModel
import kotlinx.coroutines.flow.stateIn

class TaskRepository(
    private val db: TaskDao
) {
    fun getAllData() = db.getAllTodoTask()
    suspend fun insertData(data: TaskModel) = db.insertNewTask(data)

    suspend fun findTaskById(id:Int) = db.getTaskById(id)
}