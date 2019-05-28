package com.example.nbtv.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.nbtv.R
import com.example.nbtv.model.Canal

class ListaDeCanaisAdapter(canais:List<Canal>, context:Context): BaseAdapter() {

    val context:Context = context
    val canais:List<Canal> =  canais
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val canal = canais[position]
        val view:View = LayoutInflater.from(context).inflate(R.layout.item_canal,parent, false )
        val imagem = view.findViewById<ImageView>(R.id.item_lista_image)
        val titulo = view.findViewById<TextView>(R.id.item_lista_titulo)
        imagem.setImageResource(canal.image)
        titulo.text = canal.titulo

        return view
    }

    override fun getItem(position: Int): Any {
        return canais[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return canais.size
    }
}