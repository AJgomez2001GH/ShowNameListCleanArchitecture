package com.example.myapplication4.domain.usecases

import com.example.myapplication4.data.UserRepository
import com.example.myapplication4.domain.models.UserModel


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

    fun deleteUserName(name:String){
        var nameList = insRepository.provideUserList()
        if (name in nameList) {
            println("La fruta está en la lista")
            val user = UserModel(name)
            insRepository.deleteUser(user)
        } else {
            println("La fruta no está en la lista")
        }
    }





}