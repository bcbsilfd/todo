package com.github.bcbsilfd.todo

interface TasksIntent<ACTION> {
    fun reduce(action: ACTION)
}