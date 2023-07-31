package com.example.whattodo.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.whattodo.data.model.TaskModel
import com.example.whattodo.domain.repository.TaskRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import kotlin.time.Duration

class HomeViewModel(
    private val taskRepository: TaskRepository
) : ViewModel() {
    private val _taskData = taskRepository.getAllData()
    val taskData = _taskData
    fun addNewTask(dueDate:String) = viewModelScope.launch(Dispatchers.IO) {
        taskRepository.insertData(
            TaskModel(
                taskName = "Something",
                description = "This is test",
                dueDate = dueDate
            )
        )
    }
}
/*

ZonedDateTime.now()
.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")*/
