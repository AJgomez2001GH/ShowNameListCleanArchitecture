package com.example.myapplication4.domain.usecases

import com.example.myapplication4.data.UserRepository
import com.example.myapplication4.domain.models.UserModel

class UseCaseDeleteUser (val insRepository: UserRepository){
    // Esta funcion busca si el usuario existe en la lista de usuarios
    // si el usuario existe lo elimina mediante el repositorio y regresa un mensaje
    // si el usuario no existe regresa un mensaje de error y no se comunica con el repositorio
    fun execute(name:String):String{
        val userList = insRepository.provideUserList()
        if (name in userList.map { it.name }) {
            val insUser = UserModel(name)
            insRepository.deleteUser(insUser)
            return "Deleted $name suscessfully"
        } else {
            return "Name not found, delete failed"
        }
    }
}