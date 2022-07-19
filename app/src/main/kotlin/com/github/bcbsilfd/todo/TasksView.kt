package com.github.bcbsilfd.todo

interface TasksView<STATE> {
    fun render(state: STATE)
}