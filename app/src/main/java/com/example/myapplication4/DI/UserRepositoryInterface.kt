package com.example.myapplication4.DI

import com.example.myapplication4.domain.models.UserModel

interface UserRepositoryInterface {
    fun deleteUser(user: UserModel)
    fun storeUser(user: UserModel)
    fun updateUser(oldName:String, newName:String)
    fun provideUserList():List<UserModel>
}