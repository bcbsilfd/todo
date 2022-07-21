package com.github.bcbsilfd.todo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.github.bcbsilfd.todo.databinding.FragmentTasksBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class TasksFragment : Fragment(), TasksView {

    private var _binding: FragmentTasksBinding? = null
    private val binding get() = _binding!!

    private val viewModel by lazy { TasksViewModel() }

    //Add tasks adapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentTasksBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fabCreateTask.setOnClickListener { viewModel.clickCreate() }

        viewModel.state
            .onEach { render(it) }
            .launchIn(lifecycleScope)
    }

    private fun showDialog() {
        // TODO: Replace with bottomDialogFragment
        context?.let {
            MaterialAlertDialogBuilder(it)
                .setView(R.layout.dialog_create_task)
                .setPositiveButton(android.R.string.ok, null)
                .setNegativeButton(android.R.string.cancel, null)
                .show()
                .apply {
                    val name = findViewById<EditText>(R.id.et_name)?.text ?: ""

                    getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener {
                        viewModel.clickSubmit("$name")
                        dismiss()
                    }
                }
        }
    }

    private fun showErrorMessage(msg: String) {
        context?.let {
            Toast.makeText(it, msg, Toast.LENGTH_SHORT).show()
        }
    }

    private fun addNewTask(name: String) {
        context?.let {
            Toast.makeText(it, name, Toast.LENGTH_SHORT).show()
        }
    }

    override fun render(state: TasksState) {
        when (state) {
            is TasksState.Show -> showDialog()
            is TasksState.Loading -> binding.pbLoading.isVisible = state.isLoading
            is TasksState.Create -> addNewTask(state.task.name)
            is TasksState.Error -> showErrorMessage(state.msg)
            else -> Unit
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}