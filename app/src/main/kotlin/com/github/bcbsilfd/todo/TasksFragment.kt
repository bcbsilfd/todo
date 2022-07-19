package com.github.bcbsilfd.todo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.github.bcbsilfd.todo.databinding.FragmentTasksBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class TasksFragment : Fragment() {

    private var _binding: FragmentTasksBinding? = null
    private val binding get() = _binding!!

    //Add tasks adapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentTasksBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fabCreateTask.setOnClickListener { showDialog() }
    }

    private fun showDialog() {
        context?.let {
            MaterialAlertDialogBuilder(it)
                .setView(R.layout.dialog_create_task)
                .setPositiveButton(android.R.string.ok, null)
                .setNegativeButton(android.R.string.cancel, null)
                .show()
                .apply {
                    val name = findViewById<EditText>(R.id.et_name)?.text ?: ""

                    getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener {
                        addNewTask("$name")
                        dismiss()
                    }
                }
        }
    }

    private fun addNewTask(name: String) {
        context?.let {
            Toast.makeText(it, name, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}