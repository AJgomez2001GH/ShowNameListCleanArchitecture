package com.example.myapplication4.domain.usecases

import com.example.myapplication4.data.UsersRepository
import com.example.myapplication4.domain.models.User

class AddUserUseCase(private val repo: UsersRepository) {
    fun execute(name: String) {
        if (name.isNotBlank()) repo.addUser(User(name))
    }
}
