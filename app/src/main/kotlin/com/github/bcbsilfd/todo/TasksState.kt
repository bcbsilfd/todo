package com.github.bcbsilfd.todo

sealed class TasksState {
    object Idle : TasksState()
    object Show : TasksState()
    data class Create(val task: Task) : TasksState()
    data class Loading(val isLoading: Boolean) : TasksState()
    data class Error(val msg: String) : TasksState()
}