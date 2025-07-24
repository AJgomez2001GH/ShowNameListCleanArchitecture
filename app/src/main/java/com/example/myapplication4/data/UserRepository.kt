package com.example.myapplication4.data
import com.example.myapplication4.domain.models.UserModel

// Los repositorios son encargados de operaciones CRUD (Crear, Leer, Actualizar, Eliminar)
// Se pueden hacer validaciones de las cosas que entregan y reciben (Seria un double check por que esto tambien se hace en los casos de uso)


//Vamos a recibir el objeto "Ususario" de la data class que se comunica con el repositorio (el modelo)
class UserRepository {
    var userList: MutableList<UserModel> = mutableListOf<UserModel>() // Variable para almacenar el nombre del los    ario

    fun provideUserList() = userList.toList()

    // Como el objeto ya se esta pasando como parametro no es necesario definirl el objeto de la data class con su constructor
    fun storeUser(user:UserModel){
        userList.add(user)
    }

    fun deleteUser(user:UserModel){
        userList.removeIf {
            it.name == user.name }
    }

    fun updateUser(oldName:String, newName:String){
        userList.find { it.name.equals(oldName) }?.let {
            it.name = newName
        }
    }
}