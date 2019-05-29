package com.example.nbtv

import android.content.Intent
import android.net.Uri
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
    private var urlCanal:String = "http://189.45.13.225/stream.php.m3u8?user=baita&pass=2018tv&token=1553733132&resptime=109&s=stream"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val canais: List<Canal> = getListaCanais()
        val lista = findViewById<ListView>(R.id.lista_de_canais)

        lista.adapter = ListaDeCanaisAdapter(canais, this)
        lista.setOnItemClickListener { parent, view, position, id ->
            var canal:Canal = parent.getItemAtPosition(position) as Canal
            lista.visibility = View.GONE
            menu_toolbar.setImageResource(R.drawable.ic_menu)
            playVide(position)
            changeTitulo(canal)
            isMenuClicked = !isMenuClicked

        }

        menu_toolbar.setOnClickListener{
            isMenuClicked = !isMenuClicked
            if(isMenuClicked){
                menu_toolbar.setImageResource(R.drawable.ic_close)
                lista.visibility = View.VISIBLE
            }else{
                menu_toolbar.setImageResource(R.drawable.ic_menu)
                lista.visibility = View.GONE
            }
        }

        menu_person.setOnClickListener{
            startActivity(Intent(this, PersonActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        playVide(0)
    }

    private fun changeTitulo(canal: Canal) {
        titulo_canal.text = canal.titulo
        descr_canal.text  = canal.descr
    }

    private fun playVide(position: Int) {

        var url:String=""

        val menu = when (position) {
            0 ->url = urlCanal + "39.m3u8"//bora films
            1 ->url = urlCanal + "41.m3u8"//clubinho
            2 ->url = urlCanal + "27.m3u8"//rede mosaico
            3 ->url = urlCanal + "42.m3u8"//up channel
            4 ->url = urlCanal + "37.m3u8"//entreter
            5 ->url = urlCanal + "31.m3u8"//life
            6 -> url = urlCanal + "44.m3u8"//hello tv
            7 ->url = urlCanal +"28.m3u8"//full music
            8 ->url = urlCanal + "35.m3u8"//you channel
            9 ->url = urlCanal + "36.m3u8"//canal promessa
            10 ->url = urlCanal + "29.m3u8"//24h news
            else -> "Nao existe canal"
        }

        video_view.setVideoURI(Uri.parse(url))
        video_view.start()
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
