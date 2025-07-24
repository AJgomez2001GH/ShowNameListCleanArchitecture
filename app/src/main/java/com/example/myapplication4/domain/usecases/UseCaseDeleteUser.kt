package com.example.myapplication4.domain.usecases

import com.example.myapplication4.data.UserRepository
import com.example.myapplication4.domain.models.UserModel

class UseCaseDeleteUser (val insRepository: UserRepository){
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