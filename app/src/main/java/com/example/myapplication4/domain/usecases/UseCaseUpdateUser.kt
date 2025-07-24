package com.example.myapplication4.domain.usecases

import com.example.myapplication4.data.UserRepository
import com.example.myapplication4.domain.models.UserModel

class UseCaseUpdateUser(val insRepository: UserRepository){
    fun execute(oldName: String, newName: String): String {
        val userList = insRepository.provideUserList()
        val searchResult = userList.find { it.name == oldName }
        if (searchResult != null) {
            insRepository.updateUser(oldName, newName)
            return "Updated $oldName to $newName suscessfully"
        } else {
            return "index not found, updated failed"
        }
    }
}