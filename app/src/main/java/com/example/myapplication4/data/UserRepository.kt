package com.example.myapplication4.data
import com.example.myapplication4.domain.models.UserModel

// Los repositorios son encargados de operaciones CRUD (Crear, Leer, Actualizar, Eliminar)
// Se pueden hacer validaciones de las cosas que entregan y reciben (Seria un double check por que esto tambien se hace en los casos de uso)


//Vamos a recibir el objeto "Ususario" de la data class que se comunica con el repositorio (el modelo)
class UserRepository {
    var userList: MutableList<String> = mutableListOf() // Variable para almacenar el nombre del los    ario

    init {
        //userList.add("Harcodeado1")
        //userList.add("Harcodeado2")
        //userList.add("Harcodeado3")
    }
    fun provideUserList() = userList

    // Como el objeto ya se esta pasando como parametro no es necesario definirl el objeto de la data class con su constructor
    fun storeUser(user:UserModel){
        var currentUser = user.name
        if (currentUser.isBlank()==false){
            userList.add(currentUser)
        }

    }

    fun deleteUser(user:UserModel){
        var currentUser = user.name
        userList.remove(currentUser)
    }



}