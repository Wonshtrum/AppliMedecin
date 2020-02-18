package com.example.applimedecin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        boutonConnexion.setOnClickListener {
            startActivity(Intent(this@MainActivity,ConnexionActivity::class.java))
        }
        boutonInscription.setOnClickListener {
            startActivity(Intent(this@MainActivity,FormulaireActivity::class.java))
        }
    }
}
