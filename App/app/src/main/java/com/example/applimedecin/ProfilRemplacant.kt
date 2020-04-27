package com.example.applimedecin

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_profil_remplacant.*

class ProfilRemplacant : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil_remplacant)

        val res = DoAsync {
            RequestCatalog.requeteInfoLiee(
                TicketManager.ticket.id.toString(),
                TicketManager.ticket.type
            )
        }.waitUntil()
        if (res != null) {
            println(res)
            profilRempMail.setText(res.getStringD("mail"))
            profilRempMDP.setText(res.getStringD("mdp"))
            profilRempTel.setText(res.getStringD("numTel"))
            profilRempAdresse.setText(res.getStringD("adresse"))
            profilRempSpec.setText(res.getStringD("spec"))
            profilRempKM.setText(res.getInt("kmMax").toString())
            profilRempDescription.setText(res.getStringD("description"))
        }

        profilRempModif.setOnClickListener {
            val res = DoAsync {
                RequestCatalog.saveDataRemplacant(
                    TicketManager.ticket.id.toString(),
                    "",
                    "",
                    profilRempDescription.text.toString(),
                    profilRempKM.text.toString(),
                    profilRempAdresse.text.toString(),
                    profilRempMail.text.toString(),
                    profilRempTel.text.toString(),
                    profilRempSpec.text.toString(),
                    profilRempMDP.text.toString(),
                    ""
                )
            }.waitUntil()
            println(res)
        }

        profilRetour.setOnClickListener {
            startActivity(Intent(this@ProfilRemplacant,AnnoncesActivity::class.java))
        }
    }
}
