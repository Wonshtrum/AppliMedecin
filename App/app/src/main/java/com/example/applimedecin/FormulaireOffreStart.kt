package com.example.applimedecin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_formulaire_offre_end.*
import kotlinx.android.synthetic.main.activity_formulaire_offre_start.*
import java.text.SimpleDateFormat
import java.util.*

class FormulaireOffreStart : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulaire_offre_start)

        val sdf = SimpleDateFormat("dd/MM/yyyy")
        var curDate = sdf.format(Date())

        calendarViewDebut.setOnDateChangeListener { view, year, month, dayOfMonth ->
            curDate = "$dayOfMonth/${month+1}/$year"
        }

        offreSuivantB.setOnClickListener {
            intent.setClass(this@FormulaireOffreStart, FormulaireOffreEnd::class.java)
            intent.putExtra("date1", curDate)
            startActivity(intent)
        }
    }
}