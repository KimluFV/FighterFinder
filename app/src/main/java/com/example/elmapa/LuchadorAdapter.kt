package com.example.elmapa

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_luchadorvista.view.*

class LuchadorAdapter(val contexto: Context, val luchador:List<Luchador>): RecyclerView.Adapter<LuchadorAdapter.Holder>() {

    class Holder(val vista: View):RecyclerView.ViewHolder(vista){
            fun render(luchador: Luchador){

                vista.txt_shownombre.text = luchador.nombre
                vista.txt_showapellido.text = luchador.apellido
                vista.txt_showedad.text = luchador.edad
                vista.txt_showaltura.text = luchador.altura
                vista.txt_showtelefono.text = luchador.telefono
                vista.txt_shownombreusuario.text = luchador.nombreusuario

                Picasso.get().load(luchador.imagen).into(vista.imgLuchador)

                vista.setOnClickListener(){
                    var intent = Intent(vista.getContext() , Luchadorvista::class.java)
                    intent.putExtra("nombre", luchador.nombre)
                    intent.putExtra("telefono",luchador.telefono)
                    vista.getContext().startActivity(intent)
                }


            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return Holder(layoutInflater.inflate(R.layout.activity_luchadorvista, parent, false))
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.render(luchador[position])
    }

    override fun getItemCount(): Int {
        return luchador.size
    }
}