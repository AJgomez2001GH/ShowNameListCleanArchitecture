package com.example.myapplication4.domain.usecases

import com.example.myapplication4.data.UserRepository
import com.example.myapplication4.domain.models.UserModel

class UseCaseUpdateUser(val insRepository: UserRepository){
    // Esta funcion busca si el usuario existe en la lista de usuarios
    // si el usuario existe lo actualiza mediante el repositorio y regresa un mensaje,
    // si el usuario no existe regresa un mensaje de error y no se comunica con el repositorio
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