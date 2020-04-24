package com.example.applimedecin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_offre_fin.*

class FormulaireAutreCActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_offre_fin)
        boutonSuivantC.setOnClickListener {
            intent.setClass(this@FormulaireAutreCActivity,FormulaireAutreDActivity::class.java)
            intent.putExtra("date2", calendarViewFIn.date.toString())
            startActivity(intent)
        }
    }
}