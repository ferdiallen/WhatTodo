package com.example.whattodo.presentation.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.whattodo.domain.repository.TaskRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.IOException

class DetailViewModel(
   private val repository: TaskRepository
) : ViewModel() {
    var currentTitleTask by mutableStateOf("")
        private set
    var currentDescription by mutableStateOf("")
        private set
    var selectedDate by mutableStateOf("")
        private set

    fun onCurrentTitleChange(data: String) {
        currentTitleTask = data
    }

    fun onCurrentDescriptionChange(data: String) {
        currentDescription = data
    }

    fun onSelectDateChange(data: String) {
        selectedDate = data
    }

    fun getCurrentEditData(id: Int) = viewModelScope.launch(Dispatchers.IO) {
        val res = try {
            repository.findTaskById(id)
        }catch (e:Exception){
            return@launch
        }catch (e:IOException){
            return@launch
        }
        res?.let {
            currentTitleTask = it.taskName
            currentDescription= it.description
            selectedDate = it.dueDate
        }
    }
}