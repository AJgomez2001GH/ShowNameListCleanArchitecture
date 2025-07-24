package com.example.myapplication4.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication4.domain.usecases.UseCaseAddUser
import com.example.myapplication4.domain.usecases.UseCaseDeleteUser
import com.example.myapplication4.domain.usecases.UseCaseGetUser
import com.example.myapplication4.domain.usecases.UseCaseUpdateUser
import javax.inject.Inject

class UserViewModelFactory @Inject constructor(
    private val useCaseAddUser: UseCaseAddUser,
    private val useCaseDeleteUser: UseCaseDeleteUser,
    private val useCaseGetUser: UseCaseGetUser,
    private val useCaseUpdateUser: UseCaseUpdateUser,
    ) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
            return UserViewModel(
                useCaseAddUser,
                useCaseDeleteUser,
                useCaseGetUser,
                useCaseUpdateUser) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}