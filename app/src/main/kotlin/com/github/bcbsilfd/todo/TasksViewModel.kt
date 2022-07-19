package com.github.bcbsilfd.todo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

class TasksViewModel : ViewModel() {
    private var _state: MutableSharedFlow<TasksState>? = MutableSharedFlow()
    val state get() = _state!!

    fun clickCreate() {
        produce(TasksIntent.Show)
    }

    fun clickSubmit(name: String) {
        produce(TasksIntent.Create(Task(name, "Today", "Tomorrow")))
    }

    private fun produce(intent: TasksIntent) {
        val outState = when (intent) {
            is TasksIntent.Show -> TasksState.Show
            is TasksIntent.Create -> TasksState.Create(intent.task)
        }
        viewModelScope.launch { _state?.emit(outState) }
    }

    override fun onCleared() {
        _state = null
    }
}