package com.example.applimedecin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_formulaire_offre_start.*

class FormulaireOffreStart : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulaire_offre_start)

        offreSuivantB.setOnClickListener {
            intent.setClass(this@FormulaireOffreStart, FormulaireOffreEnd::class.java)
            intent.putExtra("date1", calendarViewDebut.date.toString())
            startActivity(intent)
        }
    }
}