package com.example.applimedecin

import java.util.HashMap

class SimpleRequest(private val type: String) {
    val CLIENT = "Client"
    val OFFRE = "Offre"
    val POSTULAT = "Postulat"
    val REMPLACANT = "Remplacant"

    private val content = HashMap<String, String>()

    fun put(key: String, value: String) {
        this.content[key] = value
    }

    override fun toString(): String {
        val res = content.entries.fold("[\"$type\"") {  acc, (key, value) -> "\"$key\":\"$value\"" }
        return "$res}]"
    }
}
