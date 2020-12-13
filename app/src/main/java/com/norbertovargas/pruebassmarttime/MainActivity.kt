package com.norbertovargas.pruebassmarttime

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
import kotlinx.android.synthetic.main.login.contraseña
import kotlinx.android.synthetic.main.login.usuario

class MainActivity : AppCompatActivity() {


    val database: SQLiteDatabase by lazy{ SmartTimeOpenHelper(this).writableDatabase }
    val campoUsuario: EditText by lazy{ findViewById<EditText>(R.id.usuario)}
    val campoCorreo: EditText by lazy{ findViewById<EditText>(R.id.correo)}
    val campoContraseña: EditText by lazy{ findViewById<EditText>(R.id.contraseña)}
    lateinit var handler:SmartTimeOpenHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)


        handler = SmartTimeOpenHelper(this)
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

    fun iniciar(view: View) {
        if(handler.comprobarUsuario(usuario.text.toString(), contraseña.text.toString())){
            var intent: Intent = Intent(this, ActivityInicio::class.java)

            var bun:Bundle=Bundle()

            val campoTexto:EditText=findViewById(R.id.usuario)
            bun.putString ("correo", campoTexto.text.toString())
            intent.putExtras(bun)
            startActivity(intent)

            Toast.makeText(this,R.string.errorInsertandoUsuario, Toast.LENGTH_LONG).show()

        }
        else
            Toast.makeText(this,R.string.errorInsertandoUsuario, Toast.LENGTH_LONG).show()
    }

    fun registrarse(view: View) {
        val intent: Intent = Intent(this, ActivityRegistro::class.java)
        var bundle:Bundle= Bundle()
        bundle.putString("correo",usuario.text.toString())
        bundle.putString("contraseña",contraseña.text.toString())
        intent.putExtras(bundle)
        startActivity(intent)
    }
}
