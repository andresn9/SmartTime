package basededatos

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SmartTimeOpenHelper(val contexto: Context):
    SQLiteOpenHelper(contexto,"bd smarttime",null,1) {
    companion object {
        val tablaUsuario: String = "usuario"
        val idTablaUsuario: String = "id"
        val nombreTablaUsuario: String = "nombre"
        val correoTablaUsuario: String = "correo"
        val contraseñaTablaUsuario: String = "contraseña"
    }

    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL("create table $tablaUsuario("+idTablaUsuario+" integer primary key " +
                "autoincrement," +
                "$nombreTablaUsuario varchar(100) unique,$correoTablaUsuario varchar(100),$contraseñaTablaUsuario varchar(100))")
        p0?.execSQL("insert into $tablaUsuario($nombreTablaUsuario,$correoTablaUsuario,$contraseñaTablaUsuario) values('admin','admin@admin.com','1234')")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    fun comprobarUsuario(email: String, password:String): Boolean{
        val db = writableDatabase
        val query = "select * from usuario where correo = '$email' and contraseña = '$password'"
        val cursor= db.rawQuery(query, null)
        if (cursor.count<=0) {
            cursor.close()
            return false
        }
        cursor.close()
        return true

    }
}