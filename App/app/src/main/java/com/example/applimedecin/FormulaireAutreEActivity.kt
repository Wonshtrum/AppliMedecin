package com.example.applimedecin

import android.os.Bundle
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_formulaire_autre_e.*

class FormulaireAutreEActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulaire_autre_e)
        boutonSuivantE.setOnClickListener {

            startActivity(Intent(this@FormulaireAutreEActivity,FormulaireClientActivite::class.java))
        }
    }
}