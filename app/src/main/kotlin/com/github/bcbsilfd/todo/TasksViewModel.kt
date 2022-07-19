package com.github.bcbsilfd.todo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

class TasksViewModel : ViewModel(), TasksIntent<TasksAction> {
    private var _state: MutableSharedFlow<TasksState>? = MutableSharedFlow()
    val state get() = _state!!

    override fun reduce(action: TasksAction) {
        val outState = when (action) {
            is TasksAction.Loading -> TasksState.Loading(true)
            is TasksAction.Create -> TasksState.Create
            is TasksAction.Result -> TasksState.Result(action.name)
            is TasksAction.Error -> TasksState.Error(action.msg)
            else -> TasksState.Empty
        }
        viewModelScope.launch {
            state.emit(outState)
        }
    }

    fun clickCreateTask() {
        reduce(TasksAction.Create)
    }

    fun clickSubmitTask(name: String) {
        val action = when {
            (name.isEmpty()) -> TasksAction.Error("Name is empty")
            name.length > 20 -> TasksAction.Error("Name is too large")
            else -> TasksAction.Result(name)
        }
        reduce(action)
    }

    override fun onCleared() {
        _state = null
    }
}