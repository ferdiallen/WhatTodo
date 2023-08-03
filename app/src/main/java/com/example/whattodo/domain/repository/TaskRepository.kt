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

    suspend fun deleteDataById(id:Int) = db.deleteTask(id)

    suspend fun updateDataById(data:TaskModel) = db.updateCurrentData(data)
}