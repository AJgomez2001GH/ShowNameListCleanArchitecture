package com.example.myapplication4.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication4.data.UserRepository
import com.example.myapplication4.domain.usecases.UserUseCases

class UserViewModelFactory (private val userUseCases: UserUseCases,private val userRepository: UserRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
            return UserViewModel(userUseCases, userRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}