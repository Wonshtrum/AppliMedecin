package com.example.applimedecin

import org.json.JSONObject

object TicketManager {
    var ticket = Ticket(TypeTicket.EMPTY, -1, -1)
    fun disconnect() {
        ticket = Ticket(TypeTicket.EMPTY, -1, -1)
    }
    fun connect(json: JSONObject?): Boolean {
        println(json)
        return if (json == null || (json.getStringD("type") != TypeTicket.CLIENT && json.getStringD("type") != TypeTicket.REMPLACANT)) {
            false
        } else if (json.has("type") && json.has("id") && json.has("security")) {
            ticket = Ticket(json.getString("type"), json.getInt("id"), json.getLong("security"))
            true
        } else {
            false
        }
    }
}

fun JSONObject.getStringD(attr: String, default: String = ""): String {
    return if (has(attr)) {
        getString(attr)
    } else  {
        default
    }
}

class Ticket (val type: String, val id: Int, val security: Long)

object TypeTicket {
    val EMPTY = ""
    val NONE = "none"
    val REMPLACANT = "remplacant"
    val CLIENT = "client"
}