package com.norbertovargas.pruebassmarttime

import android.content.ContentValues
import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import basededatos.SmartTimeOpenHelper
import clases.Usuario

class ActivityRegistro : AppCompatActivity() {

    val database: SQLiteDatabase by lazy{ SmartTimeOpenHelper(this).writableDatabase }
    val campoUsuario: EditText by lazy{ findViewById<EditText>(R.id.usuario)}
    val campoCorreo: EditText by lazy{ findViewById<EditText>(R.id.correo)}
    val campoContraseña: EditText by lazy{ findViewById<EditText>(R.id.contraseña)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registrarse)
        var bundle: Bundle? =this.intent.extras
        val correoTexto:String?= bundle?.getString("correo")
        val contraseñaTexto:String?= bundle?.getString("contraseña")
        val campoCorreo = findViewById<EditText>(R.id.correo)
        campoCorreo.setText(correoTexto)
        val campoContraseña = findViewById<EditText>(R.id.contraseña)
        campoContraseña.setText(contraseñaTexto)

        refrescarDatos()
    }

    fun refrescarDatos() {
        val usuarios: ArrayList<Usuario> = arrayListOf<Usuario>()

        var cursor: Cursor = database.query(
            SmartTimeOpenHelper.tablaUsuario, null, null,
            null, null, null, SmartTimeOpenHelper.idTablaUsuario + " desc"
        )
        cursor.moveToFirst()
        while (!cursor.isAfterLast) {
            val id: Int = cursor.getInt(cursor.getColumnIndex(SmartTimeOpenHelper.idTablaUsuario))
            val nombre: String =
                cursor.getString(cursor.getColumnIndex(SmartTimeOpenHelper.nombreTablaUsuario))
            val correo: String =
                cursor.getString(cursor.getColumnIndex(SmartTimeOpenHelper.correoTablaUsuario))
            val contraseña: String =
                cursor.getString(cursor.getColumnIndex(SmartTimeOpenHelper.contraseñaTablaUsuario))

            usuarios.add(Usuario(id, nombre, correo, contraseña))

            cursor.moveToNext()
        }
    }

    fun aceptar(view: View) {

        val datosAInsertar: ContentValues = ContentValues()

        datosAInsertar.put(SmartTimeOpenHelper.nombreTablaUsuario,campoUsuario.text.toString())
        datosAInsertar.put(SmartTimeOpenHelper.correoTablaUsuario,campoCorreo.text.toString())
        datosAInsertar.put(SmartTimeOpenHelper.contraseñaTablaUsuario,campoContraseña.text.toString())
        if(database.insert(SmartTimeOpenHelper.tablaUsuario,null,datosAInsertar)>0){
            val intent: Intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }else{
            Toast.makeText(this,R.string.errorInsertandoUsuario, Toast.LENGTH_LONG).show()
        }

        refrescarDatos()


    }

}