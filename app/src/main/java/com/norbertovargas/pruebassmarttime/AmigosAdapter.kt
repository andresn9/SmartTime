package com.norbertovargas.pruebassmarttime

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class AmigosAdapter(var context: Context, var texto: String) : RecyclerView.Adapter<AmigosAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.lista_amigos, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        when (texto[position]) {
        }
    }

    override fun getItemCount(): Int {
        return texto.length
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var myImage: ImageView = itemView.findViewById(R.id.avatarAmigos)

    }
}