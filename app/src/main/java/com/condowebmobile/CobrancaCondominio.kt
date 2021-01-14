package com.condowebmobile

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.condowebmobile.dominio.Cobranca
import com.retrofit.dominio.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.time.ZoneId
import java.time.format.DateTimeFormatter

class CobrancaCondominio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cobranca_condominio)

        val intent = intent
        val tipo = intent.getStringExtra("tipo")

        val serviceRetrofit = RetrofitService()

        if (tipo != null) {
            if (tipo.toString() == "cobranca_paga") {
                this@CobrancaCondominio.title = "Cobranças Pagas"

                serviceRetrofit.api?.buscarCobrancaPaga()?.enqueue(object :
                    Callback<List<Cobranca?>?> {
                    override fun onResponse(
                        call: Call<List<Cobranca?>?>?,
                        response: Response<List<Cobranca?>?>?
                    ) {
                        val lista = response?.body();
                        val linearLayout =
                            findViewById<LinearLayout>(R.id.activityCobrancaCondominio)
                        if (lista != null) {
                            if (lista.isEmpty()) {
                                Toast.makeText(
                                    this@CobrancaCondominio,
                                    "Você não tem cobranças pagas!",
                                    Toast.LENGTH_SHORT
                                ).show()
                            } else {
                                for (cobranca in lista) {
                                    val linearLayout2 = LinearLayout(this@CobrancaCondominio)

                                    val layoutParams = LinearLayout.LayoutParams(
                                        LinearLayout.LayoutParams.MATCH_PARENT,
                                        LinearLayout.LayoutParams.WRAP_CONTENT
                                    )
                                    layoutParams.setMargins( 50 , 30 , 50 , 20 ) ;
                                    linearLayout2.setOrientation(LinearLayout.VERTICAL)
                                    linearLayout2.setBackgroundColor(Color.parseColor("#6300ee"))

                                    val textView1 = TextView(this@CobrancaCondominio)
                                    val textView2 = TextView(this@CobrancaCondominio)
                                    val textView3 = TextView(this@CobrancaCondominio)
                                    val textView4 = TextView(this@CobrancaCondominio)
                                    val textView5 = TextView(this@CobrancaCondominio)
                                    val textView6 = TextView(this@CobrancaCondominio)
                                    val textView7 = TextView(this@CobrancaCondominio)

                                    textView1.textSize = 20f
                                    textView1.text = "Nome: " + cobranca?.nome.toString()
                                    textView1.setTextColor(Color.parseColor("#ffffff"))

                                    textView2.textSize = 20f
                                    textView2.text = "Descrição: " + cobranca?.descricao.toString()
                                    textView2.setTextColor(Color.parseColor("#ffffff"))

                                    textView3.textSize = 20f
                                    textView3.text = "Valor: " + cobranca?.valor.toString()
                                    textView3.setTextColor(Color.parseColor("#ffffff"))

                                    textView4.textSize = 20f
                                    textView4.text = "Valor Pago: " + cobranca?.valorPago.toString()
                                    textView4.setTextColor(Color.parseColor("#ffffff"))

                                    textView5.textSize = 20f
                                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                                        textView5.text =
                                            "Data Vencimento: " +
                                                    cobranca?.dataVencimento?.toInstant()?.atZone(ZoneId.systemDefault())?.toLocalDate()?.format(
                                                        DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString()
                                    }
                                    textView5.setTextColor(Color.parseColor("#ffffff"))

                                    textView6.textSize = 20f
                                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                                        textView6.text =
                                            "Data Pagamento: " +
                                                    cobranca?.dataPagamento?.toInstant()?.atZone(ZoneId.systemDefault())?.toLocalDate()?.format(
                                                        DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString()
                                    }
                                    textView6.setTextColor(Color.parseColor("#ffffff"))

                                    textView7.textSize = 20f
                                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                                        textView7.text =
                                            "Data Referência: " +
                                                    cobranca?.dataReferencia?.toInstant()?.atZone(ZoneId.systemDefault())?.toLocalDate()?.format(
                                                        DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString()
                                    }
                                    textView7.setTextColor(Color.parseColor("#ffffff"))

                                    linearLayout2.addView(textView1, layoutParams)
                                    linearLayout2.addView(textView2, layoutParams)
                                    linearLayout2.addView(textView3, layoutParams)
                                    linearLayout2.addView(textView4, layoutParams)
                                    linearLayout2.addView(textView5, layoutParams)
                                    linearLayout2.addView(textView6, layoutParams)
                                    linearLayout2.addView(textView7, layoutParams)
                                    linearLayout.addView(linearLayout2, layoutParams)
                                }
                            }
                        }
                    }

                    override fun onFailure(call: Call<List<Cobranca?>?>?, t: Throwable?) {
                        Log.e("Erro", "************** erro **********\n" + t?.message.toString())
                    }
                })
            }

            if (tipo.toString() == "cobranca_nao_paga") {
                this@CobrancaCondominio.title = "Cobranças Não Pagas"

                serviceRetrofit.api?.buscarCobrancaNaoPaga()?.enqueue(object :
                    Callback<List<Cobranca?>?> {
                    override fun onResponse(
                        call: Call<List<Cobranca?>?>?,
                        response: Response<List<Cobranca?>?>?
                    ) {
                        val lista = response?.body();
                        val linearLayout = findViewById<LinearLayout>(R.id.activityCobrancaCondominio)
                        if (lista != null) {
                            if (lista.isEmpty()) {
                                Toast.makeText(this@CobrancaCondominio, "Você não tem cobranças NÃO pagas!", Toast.LENGTH_SHORT).show()
                            } else {
                                for (cobranca in lista) {
                                    val linearLayout2 = LinearLayout(this@CobrancaCondominio)

                                    val layoutParams = LinearLayout.LayoutParams(
                                        LinearLayout.LayoutParams.MATCH_PARENT,
                                        LinearLayout.LayoutParams.WRAP_CONTENT
                                    )
                                    layoutParams.setMargins( 50 , 30 , 50 , 20 ) ;
                                    linearLayout2.setOrientation(LinearLayout.VERTICAL)
                                    linearLayout2.setBackgroundColor(Color.parseColor("#6300ee"))

                                    val textView1 = TextView(this@CobrancaCondominio)
                                    val textView2 = TextView(this@CobrancaCondominio)
                                    val textView3 = TextView(this@CobrancaCondominio)
                                    val textView4 = TextView(this@CobrancaCondominio)
                                    val textView5 = TextView(this@CobrancaCondominio)
                                    val textView7 = TextView(this@CobrancaCondominio)

                                    textView1.textSize = 20f
                                    textView1.text = "Nome: " + cobranca?.nome.toString()
                                    textView1.setTextColor(Color.parseColor("#ffffff"))

                                    textView2.textSize = 20f
                                    textView2.text = "Descrição: " + cobranca?.descricao.toString()
                                    textView2.setTextColor(Color.parseColor("#ffffff"))

                                    textView3.textSize = 20f
                                    textView3.text = "Valor: " + cobranca?.valor.toString()
                                    textView3.setTextColor(Color.parseColor("#ffffff"))

                                    textView4.textSize = 20f
                                    textView4.text = "Valor Pago: " + cobranca?.valorPago.toString()
                                    textView4.setTextColor(Color.parseColor("#ffffff"))

                                    textView5.textSize = 20f
                                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                                        textView5.text =
                                            "Data Vencimento: " +
                                                    cobranca?.dataVencimento?.toInstant()?.atZone(ZoneId.systemDefault())?.toLocalDate()?.format(
                                                        DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString()
                                    }
                                    textView5.setTextColor(Color.parseColor("#ffffff"))

                                    textView7.textSize = 20f
                                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                                        textView7.text =
                                            "Data Referência: " +
                                                    cobranca?.dataReferencia?.toInstant()?.atZone(ZoneId.systemDefault())?.toLocalDate()?.format(
                                                        DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString()
                                    }
                                    textView7.setTextColor(Color.parseColor("#ffffff"))

                                    linearLayout2.addView(textView1, layoutParams)
                                    linearLayout2.addView(textView2, layoutParams)
                                    linearLayout2.addView(textView3, layoutParams)
                                    linearLayout2.addView(textView4, layoutParams)
                                    linearLayout2.addView(textView5, layoutParams)
                                    linearLayout2.addView(textView7, layoutParams)
                                    linearLayout.addView(linearLayout2, layoutParams)
                                }
                            }
                        }
                    }

                    override fun onFailure(call: Call<List<Cobranca?>?>?, t: Throwable?) {
                        Log.e("Erro", "************** erro **********\n" + t?.message.toString())
                    }
                })
            }
        }
    }
}