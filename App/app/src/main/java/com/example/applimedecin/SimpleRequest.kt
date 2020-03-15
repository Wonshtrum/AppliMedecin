package com.example.applimedecin

import io.github.rybalkinsd.kohttp.dsl.httpGet
import java.lang.Exception
import java.util.HashMap

class SimpleRequest(private val type: String) {
    private val content = HashMap<String, String>()

    fun put(key: String, value: String) {
        this.content[key] = value
    }

    fun send(url: String): String {
        val json = this.toString()
        println("HTTP REQUEST: $json")
        try {
            val body = httpGet {
                host = "62.210.83.83"
                path = url
                port = 5000
                param {
                    "json" to json
                }
            }.body()?: return "Null"
            return body.string()
        } catch (exception: Exception) {
            return "Connexion Impossible"
        }
    }

    override fun toString(): String {
        val res = content.entries.fold("[\"$type\",{") {  acc, (key, value) -> "$acc\"$key\":\"$value\"," }
        return "$res}]"
    }
}

object SimpleRequestType {
    val ANNONCES = "Annonces"
    val CLIENT = "Client"
    val OFFRE = "Offre"
    val POSTULAT = "Postulat"
    val REMPLACANT = "Remplacant"
}