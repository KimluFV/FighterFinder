package com.example.elmapa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_registrar.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Registrar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar)

        val btn = findViewById<Button>(R.id.btn_registrar)

        btn.setOnClickListener() {
            registrarLuchador()
        }

    }

    fun registrarLuchador() {
        val bd = BasedeDatos.obtenerBaseDatos(this)

        val nombre = edtxt_regNombre.text.toString()
        val apellido = edtxt_regApellido.text.toString()
        val edad = edtxt_regEdad.text.toString()
        val altura = edtxt_regAltura.text.toString()
        val telefono = editTextPhone.text.toString()
        val nombreUsuario = edtxt_regNombreusuario.text.toString()
        val contraseña = edtxt_regContraseña.text.toString()


        val luchador = Luchador(nombre, apellido,edad,altura,telefono,nombreUsuario,contraseña,"https://www.flaticon.es/icono-gratis/usuario_5368662?term=profile&page=1&position=67&page=1&position=67&related_id=5368662&origin=search")
        CoroutineScope(Dispatchers.IO).launch {
            val id = bd.Luchadores().insertarLuchador(luchador)[0]
            this@Registrar.finish()
        }

    }
}