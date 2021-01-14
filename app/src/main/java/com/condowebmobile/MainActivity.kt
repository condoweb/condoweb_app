package com.condowebmobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun condomino(view: View) {
        val intent = Intent(this, Condomino::class.java)
        startActivity(intent)
    }

    fun sindico(view: View) {
        val intent = Intent(this, Sindico::class.java)
        startActivity(intent)
    }
}