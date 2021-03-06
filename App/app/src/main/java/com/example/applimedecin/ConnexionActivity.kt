package com.example.applimedecin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_connexion.*

class ConnexionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_connexion)

        val res = DoAsync {
            SimpleRequest().send("/").success
        }.waitUntil()
        if (res == null || !res) {
            error.text = "server down"
        }

        buttonConnexion.setOnClickListener{
            val newTicket = DoAsync {
                RequestCatalog.connect(editTextMail.text.toString(), editTextMotDePasse.text.toString())
            }.waitUntil()
            if (TicketManager.connect(newTicket)) {
                startActivity(Intent(this@ConnexionActivity, AnnoncesActivity::class.java))
            } else {
                editTextMotDePasse.setText("")
            }
        }
        retour.setOnClickListener{
            startActivity(Intent(this@ConnexionActivity, MainActivity::class.java))
        }
    }
}
