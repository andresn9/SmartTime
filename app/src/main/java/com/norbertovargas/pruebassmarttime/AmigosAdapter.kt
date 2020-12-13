package com.norbertovargas.pruebassmarttime

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView

class AmigosAdapter(var mcontext: Context, var contactList: List<Contact>) : RecyclerView.Adapter<AmigosAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(mcontext)
        val view = inflater.inflate(R.layout.lista_amigos, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val contact:Contact = contactList[position]
        holder.name_contact.text = contact.name.toString()
        //holder.last_message.text = contact.lastMsg.toString()
        if (contact.photo.toString().isBlank()) {
            holder.img_contact.setImageResource(R.mipmap.ic_launcher_round)
        }else {
            holder.img_contact.setImageURI(contact.photo)
        }

        if (contact.isOnline){
            holder.status.text = R.string.online.toString()
        }else {
            holder.status.text = R.string.offline.toString()
        }

        if (contact.isUnread) {
            holder.unread_notif.visibility = ImageView.VISIBLE
        }else {
            holder.unread_notif.visibility = ImageView.INVISIBLE
        }
    }

    override fun getItemCount(): Int {
        return contactList.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name_contact:TextView = itemView.findViewById(R.id.nombreAmigos)
        var last_message:TextView = itemView.findViewById(R.id.ultimoMsg)
        var img_contact:CircleImageView = itemView.findViewById(R.id.avatarAmigos)
        var status:TextView = itemView.findViewById(R.id.estadoAmigos)
        var unread_notif:ImageView = itemView.findViewById(R.id.mensajeNuevo)
    }
}