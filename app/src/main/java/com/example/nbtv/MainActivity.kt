package com.example.nbtv

import android.opengl.Visibility
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import com.example.nbtv.adapter.ListaDeCanaisAdapter
import com.example.nbtv.model.Canal
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar_layout.*

class MainActivity : AppCompatActivity() {

    private var isMenuClicked: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val canais: List<Canal> = getListaCanais()
        val lista = findViewById<ListView>(R.id.lista_de_canais)

        lista.adapter = ListaDeCanaisAdapter(canais, this)
        lista.setOnItemClickListener { parent, view, position, id ->
            var canal:Canal = parent.getItemAtPosition(position) as Canal
            lista.visibility = View.GONE
            playVide(position)
            changeTitulo(canal)
            isMenuClicked = !isMenuClicked
        }

        menu_toolbar.setOnClickListener{
            isMenuClicked = !isMenuClicked
            if(isMenuClicked){
                menu_toolbar.setImageResource(R.drawable.ic_close)
                lista.visibility = View.GONE
            }else{
                menu_toolbar.setImageResource(R.drawable.ic_menu)
                lista.visibility = View.VISIBLE
            }
        }
    }

    private fun changeTitulo(canal: Canal) {
        titulo_canal.text = canal.titulo
        descr_canal.text  = canal.descr
    }

    private fun playVide(position: Int) {
        Toast.makeText(this, "Play Canal $position", Toast.LENGTH_SHORT).show()
    }

    private fun getListaCanais():List<Canal> {
        return listOf(
            Canal("Titulo", R.mipmap.ic_24h_new, ""),
            Canal("Titulo", R.mipmap.ic_24h_new, ""),
            Canal("Titulo", R.mipmap.ic_24h_new, ""),
            Canal("Titulo", R.mipmap.ic_24h_new, ""),
            Canal("Titulo", R.mipmap.ic_24h_new, ""))
    }
}
