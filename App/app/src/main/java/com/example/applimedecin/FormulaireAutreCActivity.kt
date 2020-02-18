package com.example.applimedecin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_formulaire.*
import kotlinx.android.synthetic.main.activity_formulaire_autre_a.*
import kotlinx.android.synthetic.main.activity_formulaire_autre_c.*

class FormulaireAutreCActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulaire_autre_c)
        boutonSuivantC.setOnClickListener {

            startActivity(Intent(this@FormulaireAutreCActivity,FormulaireAutreDActivity::class.java))
        }
    }
}