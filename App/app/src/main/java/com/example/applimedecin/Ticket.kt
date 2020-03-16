package com.example.applimedecin

import org.json.JSONObject

object TicketManager {
    var ticket = Ticket(TypeTicket.EMPTY, -1)
    fun deconnect() {
        ticket = Ticket(TypeTicket.EMPTY, -1)
    }
    fun connect(json: JSONObject) {
        ticket = Ticket(json.getString("type"), json.getInt("id"))
    }
}

class Ticket (val type: String, val id: Int)

object TypeTicket {
    val EMPTY = ""
    val REMPLACANT = "Remplacant"
    val CLIENT = "Client"
}