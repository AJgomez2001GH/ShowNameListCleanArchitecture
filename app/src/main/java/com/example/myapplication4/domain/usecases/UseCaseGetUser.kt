package com.example.myapplication4.domain.usecases

import com.example.myapplication4.data.UserRepository
import com.example.myapplication4.domain.models.UserModel

class UseCaseGetUser (val insRepository: UserRepository){
    fun execute():List<UserModel>{
        return insRepository.provideUserList()
    }
}