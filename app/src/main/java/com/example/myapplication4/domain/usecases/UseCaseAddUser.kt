package com.example.myapplication4.domain.usecases

import com.example.myapplication4.data.UserRepository
import com.example.myapplication4.domain.models.UserModel

class UseCaseAddUser(val insRepository: UserRepository){
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