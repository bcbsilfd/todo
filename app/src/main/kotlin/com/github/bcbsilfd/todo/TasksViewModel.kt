package com.github.bcbsilfd.todo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.flow.MutableStateFlow

class TasksViewModel : ViewModel() {
    private var _state: MutableStateFlow<TasksState>? = MutableStateFlow(TasksState.Idle)
    val state get() = _state!!

    fun produce(intent: TasksIntent) = mapIntentToState(intent)

    private fun mapIntentToState(intent: TasksIntent) {
        val outState = when (intent) {
            is TasksIntent.ShowDialog -> TasksState.ShowDialog
            is TasksIntent.Create -> TasksState.Create(intent.task)
            is TasksIntent.DismissDialog -> TasksState.DismissDialog
        }
        _state?.tryEmit(outState)
    }

    override fun onCleared() {
        _state = null
    }
}

class TasksViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TasksViewModel::class.java)) return TasksViewModel() as T
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}