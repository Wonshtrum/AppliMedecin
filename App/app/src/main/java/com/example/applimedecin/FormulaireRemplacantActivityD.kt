package com.example.applimedecin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_formulaire_remplacant_d.*

class FormulaireRemplacantActivityD : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulaire_remplacant_d)
        boutonSuivantDRemp.setOnClickListener {

            startActivity(Intent(this@FormulaireRemplacantActivityD,FormulaireRemplacantActivityE::class.java))
        }
    }

}