package com.github.bcbsilfd.todo

sealed class TasksIntent {
    object Show : TasksIntent()
    data class Create(val task: Task): TasksIntent()
}