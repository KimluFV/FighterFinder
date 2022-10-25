package com.example.elmapa

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface LuchadorDao {
    @Query("SELECT * FROM Luchador")
    fun obtenerLuchadores(): LiveData<List<Luchador>>
    @Query("SELECT * FROM Luchador WHERE idLuchador = :id")
    fun obtenerLuchador(id:Int): LiveData<Luchador>
    @Insert
    fun insertarLuchador(vararg luchador: Luchador):List<Long>
    @Delete
    fun eliminarLuchador(luchador: Luchador)
    @Update
    fun actualizarLuchador(luchador: Luchador)
}