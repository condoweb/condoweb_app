package com.condowebmobile

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView
import com.condowebmobile.dominio.Informativo
import com.retrofit.dominio.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.*

class InformativoImovel : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_informativo_imovel)

        val intent = intent
        val idUsuario = intent.getStringExtra("idUsuario")

        val serviceRetrofit = RetrofitService()
        if (idUsuario != null) {
            serviceRetrofit.api?.buscarInformativoUsuario(idUsuario.toLong())?.enqueue(object : Callback<List<Informativo?>?> {
                override fun onResponse(
                    call: Call<List<Informativo?>?>?,
                    response: Response<List<Informativo?>?>?
                ) {
                    val lista = response?.body();
                    val linearLayout = findViewById<LinearLayout>(R.id.activityInformativoImovel)
                    if (lista != null) {
                        for (info in lista) {
                            val linearLayout2 = LinearLayout(this@InformativoImovel)

                            val layoutParams = LinearLayout.LayoutParams(
                                LinearLayout.LayoutParams.MATCH_PARENT,
                                LinearLayout.LayoutParams.WRAP_CONTENT
                            )
                            layoutParams.setMargins( 50 , 30 , 50 , 20 ) ;
                            linearLayout2.setOrientation(LinearLayout.VERTICAL)
                            linearLayout2.setBackgroundColor(Color.parseColor("#6300ee"))

                            val textView1 = TextView(this@InformativoImovel)
                            val textView2 = TextView(this@InformativoImovel)
                            val textView3 = TextView(this@InformativoImovel)

                            textView1.textSize = 20f
                            textView1.text = "Assunto: " + info?.assunto.toString()
                            textView1.setTextColor(Color.parseColor("#ffffff"))

                            textView2.textSize = 20f
                            textView2.text = "Conteúdo: " + info?.conteudo.toString()
                            textView2.setTextColor(Color.parseColor("#ffffff"))

                            textView3.textSize = 20f
                            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                                textView3.text =
                                    "Data: " +
                                            info?.data?.toInstant()?.atZone(ZoneId.systemDefault())?.toLocalDate()?.format(
                                                DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString()
                            }
                            textView3.setTextColor(Color.parseColor("#ffffff"))

                            linearLayout2.addView(textView1, layoutParams)
                            linearLayout2.addView(textView2, layoutParams)
                            linearLayout2.addView(textView3, layoutParams)
                            linearLayout.addView(linearLayout2, layoutParams)
                        }
                    }
                }

                override fun onFailure(call: Call<List<Informativo?>?>?, t: Throwable?) {
                    Log.e("Erro", "************** erro **********\n" + t?.message.toString())
                }
            })
        }
    }
}