package com.example.myapplication4.domain.usecases

import com.example.myapplication4.DI.UserRepositoryImpl
//import com.example.myapplication4.data.UserRepository
import com.example.myapplication4.domain.models.UserModel
import javax.inject.Inject

class UseCaseGetUser @Inject constructor(val insRepository: UserRepositoryImpl){
    // Esta funcion solo regresa la lista de objetos de la clase UserModel
    fun execute():List<UserModel>{
        return insRepository.provideUserList()
    }
}