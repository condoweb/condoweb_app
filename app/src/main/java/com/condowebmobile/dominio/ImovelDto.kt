package com.condowebmobile.dominio

import java.io.Serializable

class ImovelDto : Serializable {
    var id: Long? = null
    var numero: Int? = null
    var observacao: String? = null
    var siglaBloco: String? = null
    var descricaoBloco: String? = null
    var proprieterioNome: String? = null
}