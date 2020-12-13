package com.norbertovargas.pruebassmarttime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ActivityAmigos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_amigos)

        var contenedor: RecyclerView = this.findViewById(R.id.listaAmigos)
        contenedor.removeAllViewsInLayout()
        var cadena:String = "hola"

        var recV: RecyclerView = findViewById(R.id.listaAmigos)
        var miAdaptador:AmigosAdapter = AmigosAdapter(this, cadena)
        var linearLayoutManager: LinearLayoutManager

        recV.adapter = miAdaptador
        recV.layoutManager = LinearLayoutManager(this)
    }
}