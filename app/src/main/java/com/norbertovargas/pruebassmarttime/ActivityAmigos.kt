package com.norbertovargas.pruebassmarttime

import android.content.pm.PackageManager
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.*
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.net.toUri
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_amigos.*
import kotlinx.android.synthetic.main.nav_header_main.*

class ActivityAmigos : AppCompatActivity() {

    lateinit var recV:RecyclerView
    lateinit var contactList:ArrayList<Contact>
    lateinit var adapter: AmigosAdapter
    lateinit var botonImportar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_amigos)

        ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.READ_CONTACTS), 1000)

        recV = findViewById(R.id.listaAmigos)
        recV.setHasFixedSize(true)
        recV.layoutManager = LinearLayoutManager(this)

        contactList = ArrayList<Contact>()

        adapter = AmigosAdapter(this, contactList)
        recV.adapter = adapter

        botonImportar = findViewById(R.id.importContacts)

        botonImportar.setOnClickListener{
            recV.removeAllViewsInLayout()
            if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED){
                getContacts()
            }else {
                Toast.makeText(this, "La aplicación no tiene permiso para importar contactos", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun getContacts() {
        val phones: Cursor = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null)!!
        while (phones.moveToNext()){
            val name:String = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME))
            lateinit var photo:String
            if (phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.PHOTO_URI)) != null){
                photo = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.PHOTO_URI))
            }else {
                photo = ""
            }

            val contact = Contact(name, photo.toUri())
            contactList.add(contact)
            adapter.notifyDataSetChanged()
        }
        phones.close()
    }
}