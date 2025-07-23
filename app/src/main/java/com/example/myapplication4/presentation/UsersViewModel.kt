package com.example.myapplication4.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication4.data.UsersRepository
import com.example.myapplication4.domain.usecases.AddUserUseCase
import com.example.myapplication4.domain.usecases.DeleteUserUseCase
import com.example.myapplication4.domain.usecases.GetUsersUseCase
import com.example.myapplication4.domain.usecases.UpdateUserUseCase

class UsersViewModel : ViewModel() {

    private val repository = UsersRepository()

    private val addUser = AddUserUseCase(repository)
    private val deleteUser = DeleteUserUseCase(repository)
    private val updateUser = UpdateUserUseCase(repository)
    private val getUsers = GetUsersUseCase(repository)

    private val _users = MutableLiveData<List<String>>(emptyList())
    val users: LiveData<List<String>> = _users

    fun addUser(name: String) {
        addUser.execute(name)
        refresh()
    }

    fun deleteUser(name: String) {
        deleteUser.execute(name)
        refresh()
    }

    fun updateUser(oldName: String, newName: String) {
        updateUser.execute(oldName, newName)
        refresh()
    }

    private fun refresh() {
        _users.value = getUsers.execute().map { it.name }
    }
}
