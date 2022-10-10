package com.example.elmapa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val boton = findViewById<Button>(R.id.login)

        boton.setOnClickListener(){
            val intent = Intent(this, PeleasMapa::class.java)
            startActivity(intent)
        }

    }

}