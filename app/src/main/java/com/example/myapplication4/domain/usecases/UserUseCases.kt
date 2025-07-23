package com.example.myapplication4.domain.usecases

import com.example.myapplication4.data.UserRepository
import com.example.myapplication4.domain.models.UserModel

// Esta clase regresa los estatus que se van a mostrar
// Esta clase se comunica directamente con el repositorio
class UserUseCases (val insRepository: UserRepository){
    fun validateUserName(name:String):String{
        if(name.isEmpty()){
            return "Please enter a name"
        }else{
            // Aqui si es valido hacer una instancia de la data class que se comunica con el repositprio
            val user = UserModel(name)
            // Se almacena el objeto usuario en el repositorio
            insRepository.storeUser(user)
            return "Hello $name"
        }
    }

    fun deleteUserName(name:String):String{
        var nameList = insRepository.provideUserList()
        if (name in nameList) {
            println("La fruta está en la lista")
            val user = UserModel(name)
            insRepository.deleteUser(user)
            return "Deleted $name suscessfully"
        } else {
            println("La fruta no está en la lista")
            return "Name not found, delete failed"
        }
    }

    fun updateUserName(oldName: String, newName: String): String{
        var nameList = insRepository.provideUserList()
        val indice = nameList.indexOf(oldName)
        val user = UserModel(newName)
        insRepository.updateUser(user, indice)
        if(indice != -1){
            return "Updated $oldName to $newName suscessfully"
        }
        else{
            return "index not found, update failed"
        }
    }





}