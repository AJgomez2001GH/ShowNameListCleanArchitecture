package com.example.myapplication4.DI

import com.example.myapplication4.domain.models.UserModel
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(): UserRepositoryInterface{
    var userList: MutableList<UserModel> = mutableListOf<UserModel>()
    // Generamos la instancia de "UserModel" desde el caso de uso, no es necesario enstanciarla aqui
    // La instancia es el parametro que espera la funcion, por lo tanto, la instancia no se genera en repository
    override fun storeUser(user: UserModel){
        userList.add(user)
    }


    // Generamos la instancia de "UserModel" desde el caso de uso, no es necesario enstanciarla aqui
    // La instancia es el parametro que espera la funcion, por lo tanto, la instancia no se genera en repository
    override fun  deleteUser(user: UserModel){
        userList.removeIf {
            it.name == user.name }
    }


    // Generamos la instancia de "UserModel" desde el caso de uso, no es necesario enstanciarla aqui
    // La instancia es el parametro que espera la funcion, por lo tanto, la instancia no se genera en repository
    override fun  updateUser(oldName:String, newName:String){
        userList.find { it.name.equals(oldName) }?.let {
            it.name = newName
        }
    }

    override fun  provideUserList() = userList.toList()


}