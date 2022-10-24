package com.example.elmapa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val boton = findViewById<Button>(R.id.login)
        val registrar = findViewById<TextView>(R.id.txtRegistrar)

        boton.setOnClickListener(){
            val intent = Intent(this, PeleasMapa::class.java)
            startActivity(intent)
        }

        registrar.setOnClickListener(){
            val intent = Intent(this, Registrar::class.java)
            startActivity(intent)
        }

    }

}