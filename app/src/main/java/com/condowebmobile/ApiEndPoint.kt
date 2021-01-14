package com.condowebmobile

import com.condowebmobile.dominio.Cobranca
import com.condowebmobile.dominio.ImovelDto
import com.condowebmobile.dominio.Informativo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiEndPoint {

    @GET(value = "imoveis/buscar-imovel-usuario/{idUsuario}")
    fun buscarImovelUsuario(@Path("idUsuario") idUsuario: Long?): Call<ImovelDto?>?

    @GET(value = "informativos/buscar-informativo-usuario/{idUsuario}")
    fun buscarInformativoUsuario(@Path("idUsuario") idUsuario: Long?): Call<List<Informativo?>?>?

    @GET(value = "cobrancas/cobranca-paga-imovel/{idImovel}")
    fun buscarCobrancaPagaImovel(@Path("idImovel") idImovel: Long): Call<List<Cobranca?>?>?

    @GET(value = "cobrancas/cobranca-nao-paga-imovel/{idImovel}")
    fun buscarCobrancaNaoPagaImovel(@Path("idImovel") idImovel: Long): Call<List<Cobranca?>?>?

    @GET(value = "cobrancas/cobranca-paga")
    fun buscarCobrancaPaga(): Call<List<Cobranca?>?>?

    @GET(value = "cobrancas/cobranca-nao-paga")
    fun buscarCobrancaNaoPaga(): Call<List<Cobranca?>?>?
}