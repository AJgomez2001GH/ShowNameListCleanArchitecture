package com.example.myapplication4.domain.usecases

import com.example.myapplication4.DI.UserRepositoryImpl
//import com.example.myapplication4.data.UserRepository
import com.example.myapplication4.domain.models.UserModel
import javax.inject.Inject

class UseCaseAddUser@Inject constructor(val insRepository: UserRepositoryImpl){
    // Esta funcion verifica si el texto que le pasa la UI esta vacio
    // si si el texto esta vacio regresa un mensaje
    // si si el texto no esta vacio regresa un mensaje y almacena el texto en el repositorio
    fun execute(name:String):String{
        if(name.isEmpty()){
            return "Please enter a name"
        }else{
            val user = UserModel(name)
            insRepository.storeUser(user)
            return "Hello $name"
        }
    }
}