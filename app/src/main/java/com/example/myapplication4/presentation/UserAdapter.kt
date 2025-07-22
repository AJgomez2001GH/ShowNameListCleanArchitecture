package com.example.myapplication4.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication4.R

class UserAdapter(private var userList: List<String>): RecyclerView.Adapter<UserViewHolder>() {
    // LE decimos que layout va a usar para mostarrse
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return UserViewHolder(layoutInflater.inflate(R.layout.item_name_list, parent, false))
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        // pasa por cada item y llama la funcion render del view holder
        val item = userList[position]
        holder.render(item)
    }

    // Esta funcion solo regresa el tamaño de la lista
    override fun getItemCount(): Int {
        return userList.size
    }

}