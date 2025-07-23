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

    private val _saludo = MutableLiveData<String>()
    val saludo: LiveData<String> = _saludo

    // Cuando se presiona el boton se ejecuta esta funcion
    fun onNameChanged(nameToValidate: String) {
        // Se hace la validacion del nombre y se guarda en el repo y se ,anda al live data
        _saludo.value=insUseCase.validateUserName(nameToValidate)


        // Obtener lista actual desde el repo
        val currentList = insUserRepository.provideUserList()
        _name.value = currentList
    }

    fun onNameDeleted(nameToDelete: String) {
        // Borra el nopmbre del repo y vuelve a traese la lista Y LA MANDA AL LIVE DATA
        insUseCase.deleteUserName(nameToDelete)
        val currentList = insUserRepository.provideUserList()
        _name.value = currentList
    }

    fun onNameUpdated(oldName: String, newName: String) {
         insUseCase.updateUserName(oldName, newName)
        val currentList = insUserRepository.provideUserList()
        _name.value = currentList
    }



}
