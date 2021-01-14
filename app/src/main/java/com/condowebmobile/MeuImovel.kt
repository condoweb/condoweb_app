package com.condowebmobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView
import com.condowebmobile.dominio.ImovelDto
import com.retrofit.dominio.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MeuImovel : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meu_imovel)

        val intent = intent
        val idUsuario = intent.getStringExtra("idUsuario")

        val serviceRetrofit = RetrofitService()
        if (idUsuario != null) {
            serviceRetrofit.api?.buscarImovelUsuario(idUsuario.toLong())?.enqueue(object : Callback<ImovelDto?> {
                override fun onResponse(
                    call: Call<ImovelDto?>,
                    response: Response<ImovelDto?>
                ) {
                    val meuImovel = response?.body();
                    val linearLayout = findViewById<LinearLayout>(R.id.activityMeuImovel)
                    linearLayout.gravity = Gravity.CENTER_VERTICAL;

                    val linearLayout2 = LinearLayout(this@MeuImovel)
                    linearLayout2.setPadding(11,11,11,11)
                    linearLayout2.setOrientation(LinearLayout.VERTICAL)

                    val textView1 = TextView(this@MeuImovel)
                    val textView2 = TextView(this@MeuImovel)
                    val textView3 = TextView(this@MeuImovel)
                    val textView4 = TextView(this@MeuImovel)
                    val textView5 = TextView(this@MeuImovel)

                    textView1.textSize = 20f
                    textView1.text = "Número: " + meuImovel?.numero.toString()
                    textView1.setGravity(Gravity.CENTER);

                    textView2.textSize = 20f
                    textView2.text = "Observação: " + meuImovel?.observacao.toString()
                    textView2.setGravity(Gravity.CENTER);

                    textView3.textSize = 20f
                    textView3.text = "Sigla do Bloco: " + meuImovel?.siglaBloco.toString()
                    textView3.setGravity(Gravity.CENTER);

                    textView4.textSize = 20f
                    textView4.text = "Descrição do Bloco: " + meuImovel?.descricaoBloco.toString()
                    textView4.setGravity(Gravity.CENTER);

                    textView5.textSize = 20f
                    textView5.text = "Proprietario do Imovel: " + meuImovel?.proprieterioNome.toString()
                    textView5.setGravity(Gravity.CENTER);

                    linearLayout2.addView(textView1)
                    linearLayout2.addView(textView2)
                    linearLayout2.addView(textView3)
                    linearLayout2.addView(textView4)
                    linearLayout2.addView(textView5)
                    linearLayout.addView(linearLayout2)
                }

                override fun onFailure(call: Call<ImovelDto?>, t: Throwable?) {
                    Log.e("Erro", "************** erro **********\n" + t?.message.toString())
                }
            })
        }
    }
}
