package com.example.myapplication4.domain.usecases

import com.example.myapplication4.data.UsersRepository

class DeleteUserUseCase(private val repo: UsersRepository) {
    fun execute(name: String) {
        repo.deleteUser(name)
    }
}