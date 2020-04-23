package com.example.applimedecin

import io.github.rybalkinsd.kohttp.dsl.httpGet
import org.json.JSONObject
import java.lang.Exception
import java.util.HashMap

class SimpleRequest(private val content: JSONObject = JSONObject(), private val ticket: JSONObject = JSONObject()) {

    fun put(key: String, value: String) {
        content.put(key, value)
    }

    fun addTicket(): SimpleRequest {
        ticket.put("type", TicketManager.ticket.type)
        ticket.put("id", TicketManager.ticket.id)
        ticket.put("security", TicketManager.ticket.security)
        return this
    }

    fun send(url: String): String {
        val jsonContent = content.toString()
        val jsonTicket = content.toString()
        println("           HTTP REQUEST to $url: $jsonContent\n")
        try {
            val body = httpGet {
                host = "62.210.83.83"
                path = url
                port = 5000
                param {
                    "data" to jsonContent
                    "ticket" to jsonTicket
                }
            }.body()
            val res = body?.string().orEmpty()
            println("           GET ($url): $res")
            return res
        } catch (exception: Exception) {
            println("           NO CONNECTION ($url)")
            return "Connexion Impossible"
        }
    }

    override fun toString(): String {
        return content.toString()
    }
}

object RequestCatalog {
    fun connect(mail:String, mdp:String): String {
        val data = JSONObject()
        data.put("mail", mail)
        data.put("mdp", mdp)
        return SimpleRequest(data).send(RequestURL.CONNECT)
    }

    fun getAllOffers(): String {
        return SimpleRequest().addTicket().send(RequestURL.ALL_OFFERS)
    }

    fun connexion(mail:String, mdp:String): String {
        val data = JSONObject()
        data.put("mail", mail)
        data.put("mdp", mdp)
        return SimpleRequest(data).send(RequestURL.CONNECT)
    }

    fun requeteInfoLiee(id:String, type:String): String {
        val data = JSONObject()
        data.put("id", id)
        data.put("type", type)
        return SimpleRequest(data).addTicket().send(RequestURL.LINKED_INFO)
    }

    fun requeteOffreLiee(id:String, type:String): String {
        val data = JSONObject()
        data.put("id", id)
        data.put("type", type)
        return SimpleRequest(data).addTicket().send(RequestURL.LINKED_OFFER)
    }

    fun requeteOffres(): String {
        return SimpleRequest().addTicket().send(RequestURL.ALL_OFFERS)
    }

    fun SupprimerChose(id:String, type:String): String {
        val data = JSONObject()
        data.put("id", id)
        data.put("type", type)
        return SimpleRequest(data).addTicket().send(RequestURL.DELETE)
    }

    fun recupComptesAValider(): String {
        return SimpleRequest().addTicket().send(RequestURL.WAITING_ACCOUNTS)
    }

    fun recupCandidatures(id:String, type:String): String {
        val data = JSONObject()
        data.put("id", id)
        data.put("type", type)
        return SimpleRequest(data).addTicket().send(RequestURL.CANDIDATE)
    }

    fun getAnnoncesArchivees(id:String, type:String): String {
        val data = JSONObject()
        data.put("id", id)
        data.put("type", type)
        return SimpleRequest(data).addTicket().send(RequestURL.ARCHIVES)
    }

    fun saveDataClient(idClient:String, numTel:String, adresse:String, kmMax:String, mail:String,
                       periode:String, typeOffre:String, zoneGeo:String): String {
        val data = JSONObject()
        data.put("type", "client")
        data.put("idClient", idClient)
        data.put("numTel", numTel)
        data.put("adresse", adresse)
        data.put("kmMax", kmMax)
        data.put("mail", mail)
        data.put("periode", periode)
        data.put("typeOffre", typeOffre)
        data.put("zoneGeo", zoneGeo)
        return SimpleRequest(data).addTicket().send(RequestURL.SAVE)
    }

    fun saveDataOffre(idOffre:String, idClient:String, activite:String, carteProFilename:String,
                      description:String, dispoSec:String, horaire:String, logicielUtilise:String,
                      retrocession:String, secretariat:String, spec:String, typeOffre:String,
                      typePatient:String, visiteDomicile:String): String {
        val data = JSONObject()
        data.put("type", "offre")
        data.put("idOffre", idOffre)
        data.put("idClient", idClient)
        data.put("activite", activite)
        data.put("carteProFilename", carteProFilename)
        data.put("description", description)
        data.put("dispoSec", dispoSec)
        data.put("horaire", horaire)
        data.put("logicielUtilise", logicielUtilise)
        data.put("retrocession", retrocession)
        data.put("secretariat", secretariat)
        data.put("spec", spec)
        data.put("typeOffre", typeOffre)
        data.put("typePatient", typePatient)
        data.put("visiteDomicile", visiteDomicile)
        return SimpleRequest(data).addTicket().send(RequestURL.SAVE)
    }

    fun saveDataPostulat(idPostulat:String, idOffre:String, idRemplacant:String): String {
        val data = JSONObject()
        data.put("type", "postulat")
        data.put("idPostulat", idPostulat)
        data.put("idOffre", idOffre)
        data.put("idRemplacant", idRemplacant)
        return SimpleRequest(data).addTicket().send(RequestURL.SAVE)
    }

    fun saveDataRemplacant(idRemplacant:String, carteProFilename:String, cvFilename:String,
                           description:String, dispo:String, kmMax:String, mail:String,
                           numTel:String, spec:String, zoneGeo:String): String {
        val data = JSONObject()
        data.put("type", "remplacant")
        data.put("idRemplacant", idRemplacant)
        data.put("carteProFilename", carteProFilename)
        data.put("cvFilename", cvFilename)
        data.put("description", description)
        data.put("dispo", dispo)
        data.put("kmMax", kmMax)
        data.put("mail", mail)
        data.put("numTel", numTel)
        data.put("spec", spec)
        data.put("zoneGeo", zoneGeo)
        return SimpleRequest(data).addTicket().send(RequestURL.SAVE)
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
    val SAVE = "/saveData"
    val CONNECT = "/connexion"
    val LINKED_INFO = "/requeteInfoLiee"
    val LINKED_OFFER = "/requeteOffreLiee"
    val ALL_OFFERS = "/requeteOffres"
    val DELETE = "/supprimerChose"
    val WAITING_ACCOUNTS = "/comptesAValider"
    val CANDIDATE = "/candidatures"
    val ARCHIVES = "/annoncesArchivees"
}