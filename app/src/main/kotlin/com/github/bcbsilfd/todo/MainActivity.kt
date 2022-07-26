package com.github.bcbsilfd.todo

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.github.bcbsilfd.todo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        showTasksFragment()
    }

    private fun showTasksFragment() {
        supportFragmentManager.apply {
            val fragment = findFragmentByTag(TasksFragment.TAG)

            beginTransaction().apply {
                if (fragment == null) {
                    add(binding.fvContainer.id, TasksFragment(), TasksFragment.TAG)
                } else {
                    replace(binding.fvContainer.id, fragment, TasksFragment.TAG)
                }
            }.commit()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}