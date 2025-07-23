package com.example.myapplication4.data
import com.example.myapplication4.domain.models.User

// Los repositorios son encargados de operaciones CRUD (Crear, Leer, Actualizar, Eliminar)
// Se pueden hacer validaciones de las cosas que entregan y reciben (Seria un double check por que esto tambien se hace en los casos de uso)


//Vamos a recibir el objeto "Ususario" de la data class que se comunica con el repositorio (el modelo)
class UsersRepository {
    var userList: MutableList<User> = mutableListOf<User>() // Variable para almacenar el nombre del los    ario

    fun provideUserList() = userList

    // Como el objeto ya se esta pasando como parametro no es necesario definirl el objeto de la data class con su constructor
    fun addUser(user:User){
        userList.add(user)
    }

    fun deleteUser(name: String){
        userList.removeIf {it.name.equals(name, ignoreCase = true)}
    }

    fun updateUser(oldName: String, newName: String){
        userList.find { it.name.equals(oldName, ignoreCase = true) }?.let {
            it.name = newName
        }
    }

    fun getUsers() = userList.toList() // read list provided
}