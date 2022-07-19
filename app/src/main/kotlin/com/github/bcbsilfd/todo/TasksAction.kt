package com.github.bcbsilfd.todo

sealed class TasksAction {
    object Empty : TasksAction()
    object Create : TasksAction()
    data class Result(val name: String) : TasksAction()
    data class Loading(val isLoading: Boolean) : TasksAction()
    data class Error(val msg: String) : TasksAction()
}