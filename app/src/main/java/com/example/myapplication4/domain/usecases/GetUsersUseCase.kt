package com.example.myapplication4.domain.usecases

import com.example.myapplication4.data.UsersRepository
import com.example.myapplication4.domain.models.User

class GetUsersUseCase(private val repo: UsersRepository) {
    fun execute(): List<User> = repo.getUsers()
}