package com.github.bcbsilfd.todo

sealed class TasksIntent {
    object ShowDialog : TasksIntent()
    object DismissDialog : TasksIntent()
    data class Create(val task: Task): TasksIntent()
}