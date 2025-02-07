package model

import kotlinx.serialization.Serializable

@Serializable
data class Cliente(
    val id: Int,
    val nombre_empresa: String,
    val persona_contacto: String,
    val direccion_mail: String,
    val direccion_fisica: String,
    val telefono_fijo: String,
    val telefono_movil: String,
    val fax: String
)