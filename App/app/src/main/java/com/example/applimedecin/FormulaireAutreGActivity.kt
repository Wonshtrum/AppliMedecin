package com.example.applimedecin

import android.os.Bundle
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_formulaire_client_carte.*

class FormulaireAutreGActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulaire_client_carte)
        boutonSuivantG.setOnClickListener {

            startActivity(Intent(this@FormulaireAutreGActivity,FormulaireClientCarte::class.java))
        }
    }
}
