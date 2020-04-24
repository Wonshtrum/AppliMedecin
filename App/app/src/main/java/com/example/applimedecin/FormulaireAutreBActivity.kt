package com.example.applimedecin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_offre_debut.*

class FormulaireAutreBActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_offre_debut)

        boutonSuivantB.setOnClickListener {
            intent.setClass(this@FormulaireAutreBActivity,FormulaireAutreCActivity::class.java)
            intent.putExtra("date1", calendarViewDebut.date.toString())
            startActivity(intent)
        }
    }
}