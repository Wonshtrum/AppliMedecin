package com.example.applimedecin

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_connexion.*
import kotlinx.android.synthetic.main.annonce_formulaire.*

class AnnonceActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.annonce_formulaire)

        imageButton.setOnClickListener {
            startActivity(Intent(this@AnnonceActivity, AnnoncesActivity::class.java))
        }
    }
}