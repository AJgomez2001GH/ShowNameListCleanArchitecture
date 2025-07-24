package com.example.myapplication4

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication4.data.UserRepository
import com.example.myapplication4.domain.usecases.UseCaseAddUser
import com.example.myapplication4.domain.usecases.UseCaseDeleteUser
import com.example.myapplication4.domain.usecases.UseCaseGetUser
import com.example.myapplication4.domain.usecases.UseCaseUpdateUser
import com.example.myapplication4.presentation.UserAdapter
import com.example.myapplication4.presentation.UserViewModel
import com.example.myapplication4.presentation.UserViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import androidx.activity.viewModels

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    //private lateinit var viewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Creacion de los objetos de textos y botones
        val btnMostrarSaludo = findViewById<Button>(R.id.btnGuardarUsuario)
        val btnBorrarUsuario = findViewById<Button>(R.id.btnBorrarUsuario)
        val btnActualizarUsuario = findViewById<Button>(R.id.btnActualizarUsuario)
        val txtRecibirNombre = findViewById<EditText>(R.id.txtRecibirNombre)
        val txtMostrarSaludo = findViewById<TextView>(R.id.txtMostrarSaludo)
        val txtActualizarNombre = findViewById<EditText>(R.id.txtActualizarNombre)

        // Instancias de las dependencias
        //val repository = UserRepository()
        //val useCaseAddUser = UseCaseAddUser(repository)
        //val useCaseDeleteUser = UseCaseDeleteUser(repository)
        //val useCaseGetUser = UseCaseGetUser(repository)
        //val useCaseUpdateUser = UseCaseUpdateUser(repository)

        // Instancia del view model
        //val factory = UserViewModelFactory(useCaseAddUser, useCaseDeleteUser, useCaseGetUser, useCaseUpdateUser)
        //viewModel = ViewModelProvider(this, factory)[UserViewModel::class.java]
        val viewModel: UserViewModel by viewModels()


        // Configura el RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewNames)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = UserAdapter(viewModel.name.value ?: emptyList())

        // Click del boton guardar usuario
        btnMostrarSaludo.setOnClickListener {
            val name = txtRecibirNombre.text.toString()
            viewModel.onNameAdded(name)
        }

        // Click del boton borrar usuario
        btnBorrarUsuario.setOnClickListener {
            val name = txtRecibirNombre.text.toString()
            viewModel.onNameDeleted(name)
        }

        // Click del boton actualizar usuario
        btnActualizarUsuario.setOnClickListener {
            val newName = txtActualizarNombre.text.toString()
            val oldName = txtRecibirNombre.text.toString()
            viewModel.onNameUpdated(oldName, newName)

        }

        // Escucha del live data que actualiza la lista de nombre
        // Le pasamos la lista actualizada al user adapter para que la muestre
        viewModel.name.observe(this) { message ->
            Log.i("MainActivity", "Name: ${viewModel.name.value}")
            Log.i("MainActivity", "Name: ${message}")
            recyclerView.adapter = UserAdapter(message)
        }

        // Live data que actuaaliza el estatus
        viewModel.resultado.observe(this) { saludo ->
            Log.i("MainActivity", "Name: ${saludo}")
        txtMostrarSaludo.text = saludo
        }
    }
}