package com.condowebmobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Sindico : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sindico)
    }

    fun cobrancasPagas(view: View) {
        val intent = Intent(this@Sindico, CobrancaCondominio::class.java)
        intent.putExtra("tipo", "cobranca_paga")
        startActivity(intent)
    }

    fun contasNaoPagas(view: View) {
        val intent = Intent(this@Sindico, CobrancaCondominio::class.java)
        intent.putExtra("tipo", "cobranca_nao_paga")
        startActivity(intent)
    }
}