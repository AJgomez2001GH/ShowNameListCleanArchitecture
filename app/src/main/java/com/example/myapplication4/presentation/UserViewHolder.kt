package com.example.myapplication4.presentation

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication4.R

class UserViewHolder(view: View) : RecyclerView.ViewHolder(view){
    val txtName = view.findViewById<TextView>(R.id.txtMostrarNombre)

    //Esta funcion se llama por cada elemento de la lista
    fun render(name: String){
        txtName.text = name
    }

}