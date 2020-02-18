package com.example.applimedecin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_connexion.*
import kotlinx.android.synthetic.main.activity_main.*

class ConnexionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_connexion)
        buttonCreerUnCompte.setOnClickListener {
            startActivity(Intent(this@ConnexionActivity, FormulaireActivity::class.java))
        }
        buttonConnexion.setOnClickListener{
            startActivity(Intent(this@ConnexionActivity, AnnoncesActivity::class.java))
        }
        buttonRetour.setOnClickListener{
            startActivity(Intent(this@ConnexionActivity, MainActivity::class.java))
        }
    }
}
