package com.norbertovargas.pruebassmarttime

import android.content.ContentValues
import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.ActivityNavigatorExtras
import basededatos.SmartTimeOpenHelper
import clases.Usuario

class MainActivity : AppCompatActivity() {

    val database: SQLiteDatabase by lazy{ SmartTimeOpenHelper(this).writableDatabase }
    val campoUsuario: EditText by lazy{ findViewById<EditText>(R.id.usuario)}
    val campoCorreo: EditText by lazy{ findViewById<EditText>(R.id.correo)}
    val campoContraseña: EditText by lazy{ findViewById<EditText>(R.id.contraseña)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

    }


    fun iniciarSesion(view: View) {
        val intent: Intent = Intent(this, ActivityInicio::class.java)
        startActivity(intent)

    }

    fun registrarse(view: View) {
        val intent: Intent = Intent(this,ActivityRegistro::class.java)
        startActivity(intent)

    }
}