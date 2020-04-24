package com.example.applimedecin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_formulaire.*
import kotlinx.android.synthetic.main.activity_formulaire.retour


class FormulaireActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulaire)
        boutonRemp.setOnClickListener {

            startActivity(Intent(this@FormulaireActivity,FormulaireRemplacantActivityA::class.java))
        }
        boutonAutre.setOnClickListener {

            startActivity(Intent(this@FormulaireActivity,FormulaireClientGeneral::class.java))
        }
        retour.setOnClickListener{
            startActivity(Intent(this@FormulaireActivity, MainActivity::class.java))
        }

    }

}
