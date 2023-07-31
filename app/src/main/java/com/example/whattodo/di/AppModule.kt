package com.example.whattodo.di

import androidx.room.Room
import com.example.whattodo.data.dao.TaskDao
import com.example.whattodo.data.database.TaskDatabase
import com.example.whattodo.domain.repository.TaskRepository
import com.example.whattodo.presentation.detail.DetailViewModel
import com.example.whattodo.presentation.home.HomeViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            TaskDatabase::class.java,
            "task_db"
        ).build()
    }
    single<TaskDao> {
        val db = get<TaskDatabase>()
        db.dao()
    }
    single {
        TaskRepository(get())
    }
    viewModel {
        HomeViewModel(get())
    }
    viewModel {
        DetailViewModel(get())
    }
}