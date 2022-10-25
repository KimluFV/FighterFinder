package com.example.elmapa

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


    @Database(entities=[Luchador::class], version=1)
    abstract  class BasedeDatos : RoomDatabase(){
        abstract   fun Luchadores():LuchadorDao

        companion object{
            @Volatile
            private var INSTANCIA:BasedeDatos? = null
            fun obtenerBaseDatos(contexto: Context):BasedeDatos{
                val bdInstancia = INSTANCIA
                if (bdInstancia != null){
                    return bdInstancia
                }

                synchronized(this){
                    val instancia = Room.databaseBuilder(
                        contexto.applicationContext,
                        BasedeDatos::class.java,
                        "fighterApp"
                    ).build()
                    INSTANCIA = instancia
                    return instancia
                }
            }
        }

    }
