package com.example.applimedecin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_connexion.*
import kotlinx.android.synthetic.main.activity_profil_client.*
import kotlinx.android.synthetic.main.annonce_vue.*

class AnnonceView : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.annonce_vue)

        val extras = intent.extras
        if (extras != null) {
            sujetView.text = extras.getString("sujet")
            descriptionView.text = extras.getString("description")
            complementView.text = extras.getString("complement")
            val auteur = DoAsync {
                RequestCatalog.requeteInfoLiee(extras.getString("auteur", "-1"), "client")
            }.waitUntil()
            if (auteur != null) {
                val mail = auteur.getStringD("mail")
                val tel = auteur.getStringD("numTel")
                val adresse = auteur.getStringD("adresse")
                val specialite = auteur.getStringD("specialite")
                val sec = auteur.getInt("secretariat") == 1
                val dispoSec = auteur.getInt("dispoSec")
                auteurView.text = "Mail : $mail" +
                        "\nTelephone : $tel" +
                        "\nAdresse : $adresse" +
                        "\nSpecialite : $specialite" +
                        if (sec) "\nSecretariat : " + arrayOf("sur place", "distant")[dispoSec] else ""
            }
        }
        imageButton3.setOnClickListener {
            startActivity(Intent(this@AnnonceView,AnnoncesActivity::class.java))
        }
    }
}