package com.example.elmapa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_listado_luchador.*

class ListadoLuchador : AppCompatActivity() {

    private lateinit var basedeDatos: BasedeDatos
    private lateinit var luchador: Luchador
    private lateinit var luchadorliveData:LiveData<Luchador>



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listado_luchador)
        cargarLuchador()


    }

    fun cargarLuchador(){
        var listaLuchador = emptyList<Luchador>()
        val basededatos = BasedeDatos.obtenerBaseDatos(this)
        basededatos.Luchadores().obtenerLuchadores().observe(this, Observer {
            ListaLuchador.layoutManager = LinearLayoutManager(this)
            listaLuchador =it
            val adaptador =LuchadorAdapter(this, listaLuchador)
            ListaLuchador.adapter = adaptador
        })

    }

}