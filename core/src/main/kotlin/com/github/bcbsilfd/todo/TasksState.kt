package com.github.bcbsilfd.todo

sealed class TasksState {
    object Idle : TasksState()
    object ShowDialog : TasksState()
    object DismissDialog : TasksState()
    object Loading : TasksState()
    data class Create(val task: Task) : TasksState()
    data class Error(val msg: String) : TasksState()
}