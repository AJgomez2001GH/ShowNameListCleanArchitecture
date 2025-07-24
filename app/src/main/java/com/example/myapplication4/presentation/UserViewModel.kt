package com.example.myapplication4.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication4.domain.usecases.UseCaseAddUser
import com.example.myapplication4.domain.usecases.UseCaseDeleteUser
import com.example.myapplication4.domain.usecases.UseCaseGetUser
import com.example.myapplication4.domain.usecases.UseCaseUpdateUser
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
                    val insUseCaseAddUser: UseCaseAddUser,
                    val insUseCaseDeleteUser: UseCaseDeleteUser,
                    val insUseCaseGetUser: UseCaseGetUser,
                    val insUseCaseUpdateUser: UseCaseUpdateUser,

    ): ViewModel() {
    private val _name = MutableLiveData<MutableList<String>>(mutableListOf())
    val name: LiveData<MutableList<String>> = _name

    private val _resultado = MutableLiveData<String>()
    val resultado: LiveData<String> = _resultado

    fun onNameAdded(nameToValidate: String) {
        // Valida que exista un nombre con el caso de uso (El caso de uso se comunica directamente con el repositorio), en esta misma linea manda el estatus al live data
        // Vuelve a traer la lista actualizada del repo
        // Manda la lista actualizada al live data
        _resultado.value=insUseCaseAddUser.execute(nameToValidate)
        getLatestUSerListAndSendToLiveData()
    }

    fun onNameDeleted(nameToDelete: String) {
        // Borra el nombre del repo con el caso de uso (El caso de uso se comunica directamente con el repositorio), en esta misma linea manda el estatus al live data
        // Vuelve a traer la lista actualizada del repo
        // Manda la lista actualizada al live data
        _resultado.value=insUseCaseDeleteUser.execute(nameToDelete)
        getLatestUSerListAndSendToLiveData()
    }

    fun onNameUpdated(oldName: String, newName: String) {
        // Actualiza el nombre del repo con el caso de uso (El caso de uso se comunica directamente con el repositorio), en esta misma linea manda el estatus al live data
        // Vuelve a traer la lista actualizada del repo
        // Manda la lista actualizada al live data
        _resultado.value=insUseCaseUpdateUser.execute(oldName, newName)
        getLatestUSerListAndSendToLiveData()
    }

    fun getLatestUSerListAndSendToLiveData() {
        // Vuelve a traer la lista actualizada del repo
        // Manda la lista actualizada al live data
        val currentList = insUseCaseGetUser.execute()
        _name.value = currentList.map{it.name}.toMutableList()
    }


}
