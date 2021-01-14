package com.condowebmobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Condomino : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_condomino)
    }

    fun meuImovel(view: View) {
        val intent = Intent(this@Condomino, MeuImovel::class.java)
        intent.putExtra("idUsuario", "1")
        startActivity(intent)
    }

    fun informativos(view: View) {
        val intent = Intent(this@Condomino, InformativoImovel::class.java)
        intent.putExtra("idUsuario", "1")
        startActivity(intent)
    }

    fun cobrancaPaga(view: View) {
        val intent = Intent(this@Condomino, CobrancaImovel::class.java)
        intent.putExtra("idImovel", "1")
        intent.putExtra("tipo", "cobranca_paga_imovel")
        startActivity(intent)
    }

    fun cobrancaNaoPaga(view: View) {
        val intent = Intent(this@Condomino, CobrancaImovel::class.java)
        intent.putExtra("idImovel", "1")
        intent.putExtra("tipo", "cobranca_nao_paga_imovel")
        startActivity(intent)
    }
}