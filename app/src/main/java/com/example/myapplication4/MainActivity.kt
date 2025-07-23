package com.example.myapplication4

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication4.databinding.ActivityMainBinding
import com.example.myapplication4.presentation.UsersViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: UsersViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.users.observe(this) { users ->
            binding.userListTextView.text = users.joinToString("\n")
        }

        binding.addUserButton.setOnClickListener {
            val name = binding.inputEditText.text.toString()
            viewModel.addUser(name)
        }

        binding.deleteUserButton.setOnClickListener {
            val name = binding.inputEditText.text.toString()
            viewModel.deleteUser(name)
        }

        binding.updateUserButton.setOnClickListener {
            val oldName = binding.oldNameEditText.text.toString()
            val newName = binding.inputEditText.text.toString()
            viewModel.updateUser(oldName, newName)
        }
    }
}