package com.github.bcbsilfd.todo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class TasksViewModel : ViewModel() {
    private var _state: MutableStateFlow<TasksState>? = MutableStateFlow(TasksState.Idle)
    val state get() = _state!!

    private var _intent: MutableSharedFlow<TasksIntent>? = MutableSharedFlow()

    init {
        _intent
            ?.onEach { mapIntentToState(it) }
            ?.launchIn(viewModelScope)
    }

    fun produce(intent: TasksIntent) {
        viewModelScope.launch { _intent?.emit(intent) }
    }

    private suspend fun mapIntentToState(intent: TasksIntent) {
        val outState = when (intent) {
            is TasksIntent.ShowDialog -> TasksState.ShowDialog
            is TasksIntent.Create -> TasksState.Create(intent.task)
            is TasksIntent.DismissDialog -> TasksState.DismissDialog
        }
        viewModelScope.launch {
            _state?.emit(outState)
        }
    }

    override fun onCleared() {
        _state = null
        _intent = null
    }
}