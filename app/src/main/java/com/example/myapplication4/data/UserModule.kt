package com.example.myapplication4.data

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class) // alcance app-wide (singleton)
object UserModule {
    //Para que todas las clases que neceisten un objeto de tipo UserRepository usen el mismo objeto
    //Si no creas este objeto entonces todas las clases que necesitan un objeto de tipo UserRepository van a crear el suyo y eso esta mal
    //Si todas las clases crean un user repository entonces todas las clases van a tener su propio objeto en lugar de usar el mismo objeto
    //Con esto ahora todas las clases van a usar el mismo objeto y no van a crear uno nuevo

    // Con las anotaciones @Provides y @Singleton creamos un solo objeto de tipo UserRepository que se inyecta a las clases que lo necesitan, por eso sale que la funcion si esta siendo llamada aunque no la llamemos directamente
    // Si cualquiera de las clases necesita un objeto de repositorio lo va a tomar de aqui
    @Provides
    @Singleton
    fun provideUserRepository(): UserRepository {
        return UserRepository()
    }

    //Si necesitamos proveer otro objeto lo agregariamos aqui
    //@Provides
    //@Singleton
    //fun provideOtroObjetoDeotraClase(): OtraClase {
    //    return OtraClase()
    //}
}
