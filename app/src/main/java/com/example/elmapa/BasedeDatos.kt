package com.example.elmapa

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities=[Luchador::class], version=1)
abstract  class BaseDatos : RoomDatabase(){
    abstract   fun Luchadores():LibroDAO

    companion object{
        @Volatile
        private var INSTANCIA:BaseDatos? = null
        fun obtenerBaseDatos(contexto:Context):BaseDatos{
            val bdInstancia = INSTANCIA
            if (bdInstancia != null){
                return bdInstancia
            }

            synchronized(this){
                val instancia = Room.databaseBuilder(
                    contexto.applicationContext,
                    BaseDatos::class.java,
                    "fighterApp"
                ).build()
                INSTANCIA = instancia
                return instancia
            }
        }
    }

}