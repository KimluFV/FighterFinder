package com.example.elmapa

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class Luchadorvista : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_luchadorvista)

        val btnPelear = findViewById<Button>(R.id.btn_pelear)
        val btnVer = findViewById<Button>(R.id.btn_vermas)

        val telefono: String?
            telefono = if (savedInstanceState == null) {
            val extras = intent.extras
            extras?.getString("telefono")
        } else {
            savedInstanceState.getSerializable("telefono") as String?
        }


        btnPelear.setOnClickListener() {

            val url = "https://wa.me/$telefono"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)

            }
        btnVer.setOnClickListener(){
            val intent = Intent(this, ListadoLuchador::class.java)
            startActivity(intent)
        }

        }
        }



