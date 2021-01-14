package com.condowebmobile.dominio

import java.io.Serializable
import java.util.*

class Cobranca : Serializable {
    var id: Long? = null
    var nome: String? = null
    var descricao: String? = null
    var valor: Double? = null
    var valorPago: Double? = null
    var dataPagamento: Date? = null
    var dataVencimento: Date? = null
    var dataReferencia: Date? = null
}