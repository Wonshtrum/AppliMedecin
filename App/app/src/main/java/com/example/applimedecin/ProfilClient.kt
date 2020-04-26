package com.example.applimedecin

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
            profilClientKM.setProgress(res.getInt("kmMax"), true)
            profilClientSecretariat.isChecked = res.getInt("secretariat") == 1
            profilClientDispoSec.setSelection(res.getInt("dispoSec"))
            if (!profilClientSecretariat.isChecked) {
                profilClientHint.isEnabled = false
                profilClientDispoSec.isEnabled = false
            }
        }

        imageButton2.setOnClickListener {
            startActivity(Intent(this@ProfilClient,AnnoncesActivity::class.java))
        }
    }
}
