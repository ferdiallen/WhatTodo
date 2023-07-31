package com.example.whattodo.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.whattodo.data.model.TaskModel
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {
    @Query("SELECT * FROM TaskModel")
    fun getAllTodoTask(): Flow<List<TaskModel>>

    @Insert
    suspend fun insertNewTask(data: TaskModel)

    @Query("SELECT * FROM TaskModel where id =:idData")
    suspend fun getTaskById(idData:Int): TaskModel?

    @Query("DELETE from TaskModel where id =:taskId")
    suspend fun deleteTask(taskId: Int)

    @Delete
    suspend fun deleteAllTask(data:List<TaskModel>)
}