package com.example.myapplication4.domain.usecases

import com.example.myapplication4.data.UsersRepository

class UpdateUserUseCase(private val repo: UsersRepository) {
    fun execute(oldName: String, newName: String) {
        if (newName.isNotBlank()) repo.updateUser(oldName, newName)
    }
}