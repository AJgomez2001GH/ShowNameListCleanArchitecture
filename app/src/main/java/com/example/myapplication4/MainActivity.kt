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
import com.example.myapplication4.domain.usecases.UserUseCases
import com.example.myapplication4.presentation.UserAdapter
import com.example.myapplication4.presentation.UserViewModel
import com.example.myapplication4.presentation.UserViewModelFactory
import kotlinx.coroutines.delay

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnMostrarSaludo = findViewById<Button>(R.id.btnGuardarUsuario)
        val txtRecibirNombre = findViewById<EditText>(R.id.txtRecibirNombre)
        val txtMostrarSaludo = findViewById<TextView>(R.id.txtMostrarSaludo)
        val btnBorrarUsuario = findViewById<Button>(R.id.btnBorrarUsuario)
        val btnActualizarUsuario = findViewById<Button>(R.id.btnActualizarUsuario)
        val txtActualizarNombre = findViewById<EditText>(R.id.txtActualizarNombre)

        val repository = UserRepository()
        val userUseCase = UserUseCases(repository)
        val factory = UserViewModelFactory(userUseCase, repository)
        viewModel = ViewModelProvider(this, factory)[UserViewModel::class.java]

        // Configura el RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewNames)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = UserAdapter(viewModel.name.value ?: emptyList())

        btnMostrarSaludo.setOnClickListener {
            val name = txtRecibirNombre.text.toString()
            viewModel.onNameChanged(name)
        }


        btnBorrarUsuario.setOnClickListener {
            val name = txtRecibirNombre.text.toString()
            viewModel.onNameDeleted(name)
        }

        btnActualizarUsuario.setOnClickListener {
            val newName = txtActualizarNombre.text.toString()
            val oldName = txtRecibirNombre.text.toString()
            viewModel.onNameUpdated(oldName, newName)

        }


        // Se obtiene el dato del live data
        // Le pasamos la lista actualizada al user adapter para que la muestre
        viewModel.name.observe(this) { message ->
            Log.i("MainActivity", "Name: ${viewModel.name.value}")
            Log.i("MainActivity", "Name: ${message}")
            recyclerView.adapter = UserAdapter(message)
        }

        // Live data para el saludo
        viewModel.resultado.observe(this) { saludo ->
            Log.i("MainActivity", "Name: ${saludo}")
        txtMostrarSaludo.text = saludo
        }
    }
}