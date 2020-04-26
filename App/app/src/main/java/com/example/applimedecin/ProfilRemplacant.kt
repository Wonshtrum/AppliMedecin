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
            profilRempKM.setProgress(res.getInt("kmMax"), true)
            editTextDescRemp2.setText(res.getStringD("description"))
        }

        imageButton2.setOnClickListener {
            startActivity(Intent(this@ProfilRemplacant,AnnoncesActivity::class.java))
        }
    }
}
