package com.example.hito1JohanAcaroCRUD

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.support.v4.app.Fragment


class DataHelper(context: Fragment) : SQLiteOpenHelper(
    context.context, NOMBRE_DATABASE, null, VERSION_DATABASE
) {


    companion object {
        const val NOMBRE_DATABASE = "tienda.db"
        const val VERSION_DATABASE = 1
        const val NOMBRE_TABLE = "productos"
        const val CAMPO_ID= "id"
        const val CAMPO_NOMBRE = "nombre"
        const val CAMPO_UNIDADES = "unidades"
        const val CAMPO_PRECIO = "precio"
    }

    override fun onCreate(db: SQLiteDatabase?) {

        val crearTabla =
            ("CREATE TABLE productos (id INTEGER PRIMARY KEY, nombre TEXT NOT NULL, unidades INTEGER, precio TEXT NOT NULL)")
        try {
            if (db != null) {
                println("base de datos creada")
                db.execSQL(crearTabla)
                println("tabla creada")
            }
        }
        catch (e: Exception){
            println("error al crear la tabla")
        }

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $NOMBRE_TABLE")
        onCreate(db)
    }

    fun addProducto(producto: Producto) {
        try {
            val db = this.writableDatabase
            val values = ContentValues()
            values.put(CAMPO_NOMBRE, producto.nombre)
            values.put(CAMPO_UNIDADES, producto.unidades)
            values.put(CAMPO_PRECIO, producto.precio)
            db.insert(NOMBRE_TABLE, null, values)
            db.close()
        } catch (e: Exception) {
            println("error al insertar")
        }

    }

    fun getAllProducts(): ArrayList<Producto> {
        try {
            println("Listado de productos")
            var listaProductos = ArrayList<Producto>()
            var db = this.writableDatabase
            var resultado = db.rawQuery("select * from productos", null)
            if (resultado.moveToFirst()) {
                do {
                    val producto = Producto(0, "", 0, "")
                    producto.id = resultado.getInt(0)
                    producto.nombre = resultado.getString(1)
                    producto.unidades = resultado.getInt(2)
                    producto.precio = resultado.getString(3)
                    listaProductos.add(producto)
                } while (resultado.moveToNext())
            }

            println(listaProductos)
            return listaProductos
        }
        catch (e: Exception){
            println("error al listar")
            return ArrayList()
        }

    }
}
