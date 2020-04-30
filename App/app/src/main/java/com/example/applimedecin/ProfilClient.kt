package com.example.applimedecin

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_profil_client.*

class ProfilClient : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil_client)

        val res = DoAsync {
            RequestCatalog.requeteInfoLiee(
                TicketManager.ticket.id.toString(),
                TicketManager.ticket.type
            )
        }.waitUntil()
        if (res != null) {
            profilClientMail.setText(res.getStringD("mail"))
            profilClientMDP.setText(res.getStringD("mdp"))
            profilClientTel.setText(res.getStringD("numTel"))
            profilClientAdresse.setText(res.getStringD("adresse"))
            profilClientSpec.setText(res.getStringD("specialite"))
            profilClientAlone.isChecked = res.getInt("activite") == 1
            profilClientKM.setText(res.getInt("kmMax").toString())
            profilClientSecretariat.isChecked = res.getInt("secretariat") == 1
            profilClientDispoSec.setSelection(res.getInt("dispoSec"))
            if (!profilClientSecretariat.isChecked) {
                profilClientHint.isEnabled = false
                profilClientDispoSec.isEnabled = false
            }
        }

        profilClientSecretariat.setOnClickListener {
            profilClientHint.isEnabled = profilClientSecretariat.isChecked
            profilClientDispoSec.isEnabled = profilClientSecretariat.isChecked
        }

        profilClientModif.setOnClickListener {
            val res = DoAsync {
                RequestCatalog.saveDataClient(
                    TicketManager.ticket.id.toString(),
                    profilClientTel.text.toString(),
                    profilClientAdresse.text.toString(),
                    profilClientKM.text.toString(),
                    profilClientMail.text.toString(),
                    profilClientSpec.text.toString(),
                    if (profilClientSecretariat.isChecked) "1" else "0",
                    profilClientDispoSec.selectedItemId.toString(),
                    if (profilClientAlone.isChecked) "1" else "0",
                    profilClientMDP.text.toString(),
                    "",
                    ""
                )
            }.waitUntil()
            println(res)
        }

        profilRetour.setOnClickListener {
            startActivity(Intent(this@ProfilClient,AnnoncesActivity::class.java))
        }
    }
}
