package com.example.applimedecin

import io.github.rybalkinsd.kohttp.dsl.httpGet
import org.json.JSONObject
import java.lang.Exception
import java.util.HashMap

class SimpleRequest(private val content: JSONObject = JSONObject()) {

    fun put(key: String, value: String) {
        content.put(key, value)
    }

    fun addTicket() {
        content.put("type", TicketManager.ticket.type)
        content.put("id", TicketManager.ticket.id)
    }

    fun send(url: String): String {
        addTicket()
        val json = this.toString()
        println("           HTTP REQUEST to $url: $json\n")
        try {
            val body = httpGet {
                host = "62.210.83.83"
                path = url
                port = 5000
                param {
                    "data" to json
                }
            }.body()
            val res = body?.string().orEmpty()
            println("           GET: $res")
            return res
        } catch (exception: Exception) {
            println("           NO CONNEXION")
            return "Connexion Impossible"
        }
    }

    override fun toString(): String {
        return content.toString()
    }
}

object SimpleRequestField {
    val OFFRE = "Offre"
    val POSTULAT = "Postulat"
    val ID_CLIENT = "idClient"
    val ID_OFFRE = "idOffre"
    val ID_POSTULAT = "idPostulat"
    val ID_REMPLACANT = "idRemplacant"
}

object RequestURL {
    val TEST = "/test2"
    val SAVE_DATA = "/saveData"
    val CONNECT = "/connexion"
    val LINKED_INFO = "/requeteInfoLiee"
    val LINKED_OFFER = "/requeteOffreLiee"
    val ALL_OFFERS = "/requeteOffres"
    val DELETE = "/supprimerChose"
    val WAITING_ACCOUNTS = "/comptesAValider"
    val CANDIDATE = "/candidatures"
}