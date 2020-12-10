package com.norbertovargas.pruebassmarttime

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import basededatos.SmartTimeOpenHelper

class MainActivity : AppCompatActivity() {

    val database: SQLiteDatabase by lazy{ SmartTimeOpenHelper(this).writableDatabase }
    val campoUsuario: EditText by lazy{ findViewById<EditText>(R.id.usuario)}
    val campoCorreo: EditText by lazy{ findViewById<EditText>(R.id.correo)}
    val campoContraseña: EditText by lazy{ findViewById<EditText>(R.id.contraseña)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

    }


    fun iniciar(view: View) {
        val intent: Intent = Intent(this, ActivityInicio::class.java)
        startActivity(intent)

    }

    fun registrarse(view: View) {
        val intent: Intent = Intent(this,ActivityRegistro::class.java)
        startActivity(intent)

    }
}