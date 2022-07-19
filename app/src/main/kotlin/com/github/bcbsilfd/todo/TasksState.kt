package com.github.bcbsilfd.todo

sealed class TasksState {
    object Empty : TasksState()
    object Create : TasksState()
    data class Result(val name: String) : TasksState()
    data class Loading(val isLoading: Boolean) : TasksState()
    data class Error(val msg: String) : TasksState()
}