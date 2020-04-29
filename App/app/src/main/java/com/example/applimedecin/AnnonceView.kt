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
        }
        imageButton3.setOnClickListener {
            startActivity(Intent(this@AnnonceView,AnnoncesActivity::class.java))
        }
    }
}