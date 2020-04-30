package com.example.applimedecin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_formulaire_offre_end.*
import android.widget.CalendarView
import android.widget.CalendarView.OnDateChangeListener
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import java.text.SimpleDateFormat
import java.util.*


class FormulaireOffreEnd : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulaire_offre_end)

        val sdf = SimpleDateFormat("dd/MM/yyyy")
        var curDate = sdf.format(Date())

        calendarViewFIn.setOnDateChangeListener { view, year, month, dayOfMonth ->
            curDate = "$dayOfMonth/${month+1}/$year"
        }

        offreSuivantC.setOnClickListener {
            intent.setClass(this@FormulaireOffreEnd, FormulaireOffreSchedule::class.java)
            intent.putExtra("date2", curDate)
            startActivity(intent)
        }
    }
}