package com.example.myapplication4.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication4.data.UserRepository
import com.example.myapplication4.domain.usecases.UserUseCases

class UserViewModel(val insUseCase: UserUseCases,
                    val insUserRepository: UserRepository): ViewModel() {
    private val _name = MutableLiveData<MutableList<String>>(mutableListOf())
    val name: LiveData<MutableList<String>> = _name

    private val _resultado = MutableLiveData<String>()
    val resultado: LiveData<String> = _resultado

    fun onNameChanged(nameToValidate: String) {
        // Valida que exista un nombre con el caso de uso (El caso de uso se comunica directamente con el repositorio), en esta misma linea manda el estatus al live data
        // Vuelve a traer la lista actualizada del repo
        // Manda la lista actualizada al live data
        _resultado.value=insUseCase.validateUserName(nameToValidate)
        val currentList = insUserRepository.provideUserList()
        _name.value = currentList
    }

    fun onNameDeleted(nameToDelete: String) {
        // Borra el nombre del repo con el caso de uso (El caso de uso se comunica directamente con el repositorio, en esta misma linea manda el estatus al live data
        // Vuelve a traer la lista actualizada del repo
        // Manda la lista actualizada al live data
        _resultado.value=insUseCase.deleteUserName(nameToDelete)
        val currentList = insUserRepository.provideUserList()
        _name.value = currentList
    }

    fun onNameUpdated(oldName: String, newName: String) {
        // Actualiza el nombre del repo con el caso de uso (El caso de uso se comunica directamente con el repositorio, en esta misma linea manda el estatus al live data
        // Vuelve a traer la lista actualizada del repo
        // Manda la lista actualizada al live data
        _resultado.value=insUseCase.updateUserName(oldName, newName)
        val currentList = insUserRepository.provideUserList()
        _name.value = currentList
    }



}
