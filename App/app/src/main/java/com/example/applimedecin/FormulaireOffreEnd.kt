package com.example.applimedecin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_formulaire_offre_end.*

class FormulaireOffreEnd : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulaire_offre_end)
        offreSuivantC.setOnClickListener {
            intent.setClass(this@FormulaireOffreEnd, FormulaireOffreSchedule::class.java)
            intent.putExtra("date2", calendarViewFIn.date.toString())
            startActivity(intent)
        }
    }
}