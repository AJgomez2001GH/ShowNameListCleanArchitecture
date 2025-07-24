package com.example.myapplication4.data
import com.example.myapplication4.domain.models.UserModel
import javax.inject.Inject

// Los repositorios son encargados de operaciones CRUD (Crear, Leer, Actualizar, Eliminar)
// Se pueden hacer validaciones de las cosas que entregan y reciben (Seria un double check por que esto tambien se hace en los casos de uso)


//Vamos a recibir el objeto "Ususario" de la data class que se comunica con el repositorio (el modelo)
class UserRepository @Inject constructor(){
    var userList: MutableList<UserModel> = mutableListOf<UserModel>()

    // Generamos la instancia de "UserModel" desde el caso de uso, no es necesario enstanciarla aqui
    // La instancia es el parametro que espera la funcion, por lo tanto, la instancia no se genera en repository
    fun storeUser(user:UserModel){
        userList.add(user)
    }


    // Generamos la instancia de "UserModel" desde el caso de uso, no es necesario enstanciarla aqui
    // La instancia es el parametro que espera la funcion, por lo tanto, la instancia no se genera en repository
    fun deleteUser(user:UserModel){
        userList.removeIf {
            it.name == user.name }
    }


    // Generamos la instancia de "UserModel" desde el caso de uso, no es necesario enstanciarla aqui
    // La instancia es el parametro que espera la funcion, por lo tanto, la instancia no se genera en repository
    fun updateUser(oldName:String, newName:String){
        userList.find { it.name.equals(oldName) }?.let {
            it.name = newName
        }
    }

    fun provideUserList() = userList.toList()
}