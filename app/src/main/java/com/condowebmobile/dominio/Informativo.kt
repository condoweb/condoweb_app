package com.condowebmobile.dominio

import java.io.Serializable
import java.util.*

class Informativo : Serializable {
    var id: Long? = null
    var assunto: String? = null
    var conteudo: String? = null
    var data: Date? = null
}
