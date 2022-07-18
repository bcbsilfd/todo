package com.github.bcbsilfd.todo

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.bcbsilfd.todo.databinding.FragmentFirstBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class FirstFragment : Fragment() {
    // This property is only valid between onCreateView and
    // onDestroyView.
    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            context?.let { showDialog(it) }
        }
    }

    private fun showDialog(context: Context) {
        MaterialAlertDialogBuilder(context)
            .setView(R.layout.dialog_create_task)
            .setPositiveButton(android.R.string.ok) { _, _ -> addNewTask() }
            .setNegativeButton(android.R.string.cancel, null)
            .show()
    }

    private fun addNewTask() {
        //Add new item to recyclerView
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}