package com.example.applimedecin

import org.json.JSONObject

object TicketManager {
    var ticket = Ticket(TypeTicket.EMPTY, -1, -1)
    fun deconnect() {
        ticket = Ticket(TypeTicket.EMPTY, -1, -1)
    }
    fun connect(json: JSONObject?): Boolean {
        return if (json == null) {
            false
        } else if (json.has("type") && json.has("id") && json.has("security")) {
            ticket = Ticket(json.getString("type"), json.getInt("id"), json.getLong("security"))
            true
        } else {
            false
        }
    }
}

class Ticket (val type: String, val id: Int, val security: Long)

object TypeTicket {
    val EMPTY = ""
    val REMPLACANT = "Remplacant"
    val CLIENT = "Client"
}