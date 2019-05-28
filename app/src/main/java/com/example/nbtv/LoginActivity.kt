package com.example.nbtv

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val login = findViewById<EditText>(R.id.edt_login)
        val senha = findViewById<EditText>(R.id.edt_senha)
        val btn_entrar = findViewById<Button>(R.id.btn_logar)

        btn_entrar.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}
